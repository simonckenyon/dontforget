package ie.koala.dontforget

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class InfoController {
	
	def learn() { }
	
	def contact() { }

    def about() { }
}
