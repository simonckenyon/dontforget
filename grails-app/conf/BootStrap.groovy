import grails.util.Environment

import ie.koala.dontforget.UserRole
import ie.koala.dontforget.Role
import ie.koala.dontforget.User

class BootStrap {

	def init = { servletContext ->
		switch(Environment.current) {
			case Environment.DEVELOPMENT:
				createRoles()
				createAdminUser()
				createTestUser()
				println "created development users and roles"
				break
			case Environment.TEST:
				createRoles()
				createAdminUser()
				createTestUser()
				println "created test users and roles"
				break
			case Environment.PRODUCTION:
				createRoles()
				createAdminUser()
				createTestUser()
				println "created production users and roles"
				break
		}
	}
	def destroy = {
	}

	void createRoles() {
		if (!Role.findByAuthority('ROLE_ADMIN')) {
			println "creating ROLE_ADMIN"
			def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
		} else {
			println "existing ROLE_ADMIN"
		}
		if (!Role.findByAuthority('ROLE_USER')) {
			println "creating ROLE_USER"
			def roleUser = new Role(authority: 'ROLE_USER').save(failOnError: true)
		} else {
			println "existing ROLE_USER"
		}
	}

	void createAdminUser() {
		def roleUser = Role.findByAuthority('ROLE_USER')
		def roleAdmin = Role.findByAuthority('ROLE_ADMIN')
		if (!User.findByUsername("admin")) {
			println 'creating user "admin"'
			def userAdmin = User.findByUsername('admin') ?: new User(
					username: "admin",
					password: "adm1n",
					enabled: true).save()
			if (!userAdmin.authorities.contains(roleAdmin)) {
				UserRole.create userAdmin, roleUser
				UserRole.create userAdmin, roleAdmin, true
			}
		} else {
			println 'existing user "admin"'
		}
	}

	void createTestUser() {
		def role = Role.findByAuthority('ROLE_USER')
		if (!User.findByUsername("test")) {
			println 'creating user "test"'
			def user = User.findByUsername('test') ?: new User(
					username: "test",
					password: "abc123",
					enabled: true).save()
			if (!user.authorities.contains(role)) {
				UserRole.create user, role, true
			}
		} else {
			println 'existing user "test"'
		}
	}
}
