package ie.koala.dontforget

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class ReminderController {

    static scaffold = true
}
