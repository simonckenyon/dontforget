package ie.koala.dontforget

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityUtils

@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class ReminderController {

	static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

	def springSecurityService

	def index() {
		redirect action: 'list', params: params
	}

	def list() {
		List<Reminder> list
		int count

		User user = springSecurityService.currentUser
		boolean isAdmin = SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')
		log.debug "user=${user} isAdmin=${isAdmin}"

		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (isAdmin) {
			list = Reminder.list(params)
			count = Reminder.count()
		} else {
			list = Reminder.findAllByUser(user, params)
			count = list.size()
		}
		[reminderInstanceList: list, reminderInstanceTotal: count]
	}

	def create() {
		User user = springSecurityService.currentUser
		boolean isAdmin = SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')
		log.debug "user=${user} isAdmin=${isAdmin}"

		switch (request.method) {
			case 'GET':
				[reminderInstance: new Reminder(params)]
				break
			case 'POST':
				def reminderInstance
				if (isAdmin) {
					reminderInstance = new Reminder(params)
				} else {
					reminderInstance = new Reminder(user: user)
					bindData(reminderInstance, params, [exclude: ['user']])
				}
				if (!reminderInstance.save(flush: true)) {
					render view: 'create', model: [reminderInstance: reminderInstance]
					return
				}

				flash.message = message(code: 'default.created.message', args: [
					message(code: 'reminder.label', default: 'Reminder'),
					reminderInstance.id
				])
				redirect action: 'show', id: reminderInstance.id
				break
		}
	}

	def show() {
		User user = springSecurityService.currentUser
		boolean isAdmin = SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')
		log.debug "user=${user} isAdmin=${isAdmin}"

		def reminderInstance
		if (isAdmin) {
			reminderInstance = Reminder.get(params.id)
		} else {
			reminderInstance = Reminder.findWhere(user: user, id: params.long('id'))
		}
		if (!reminderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'reminder.label', default: 'Reminder'),
				params.id
			])
			redirect action: 'list'
			return
		}

		[reminderInstance: reminderInstance]
	}

	def edit() {
		User user = springSecurityService.currentUser
		boolean isAdmin = SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')
		log.debug "user=${user} isAdmin=${isAdmin}"

		def reminderInstance
		if (isAdmin) {
			reminderInstance = Reminder.get(params.id)
		} else {
			reminderInstance = Reminder.findWhere(user: user, id: params.long('id'))
		}
		switch (request.method) {
			case 'GET':
				if (!reminderInstance) {
					flash.message = message(code: 'default.not.found.message', args: [
						message(code: 'reminder.label', default: 'Reminder'),
						params.id
					])
					redirect action: 'list'
					return
				}

				[reminderInstance: reminderInstance]
				break
			case 'POST':
				if (!reminderInstance) {
					flash.message = message(code: 'default.not.found.message', args: [
						message(code: 'reminder.label', default: 'Reminder'),
						params.id
					])
					redirect action: 'list'
					return
				}

				if (params.version) {
					def version = params.version.toLong()
					if (reminderInstance.version > version) {
						reminderInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
								[
									message(code: 'reminder.label', default: 'Reminder')] as Object[],
								"Another user has updated this Reminder while you were editing")
						render view: 'edit', model: [reminderInstance: reminderInstance]
						return
					}
				}

				reminderInstance.properties = params

				if (!reminderInstance.save(flush: true)) {
					render view: 'edit', model: [reminderInstance: reminderInstance]
					return
				}

				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'reminder.label', default: 'Reminder'),
					reminderInstance.id
				])
				redirect action: 'show', id: reminderInstance.id
				break
		}
	}

	def delete() {
		User user = springSecurityService.currentUser
		boolean isAdmin = SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')
		log.debug "user=${user} isAdmin=${isAdmin}"

		def reminderInstance
		if (isAdmin) {
			reminderInstance = Reminder.get(params.id)
		} else {
			reminderInstance = Reminder.findWhere(user: user, id: params.long('id'))
		}
		if (!reminderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'reminder.label', default: 'Reminder'),
				params.id
			])
			redirect action: 'list'
			return
		}

		try {
			reminderInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'reminder.label', default: 'Reminder'),
				params.id
			])
			redirect action: 'list'
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'reminder.label', default: 'Reminder'),
				params.id
			])
			redirect action: 'show', id: params.id
		}
	}
}
