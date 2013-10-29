package ie.koala.dontforget

import grails.plugin.spock.UnitSpec
import org.apache.log4j.ConsoleAppender
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.PatternLayout

class UserSpec extends UnitSpec {
	
	static
	{
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.WARN);
		rootLogger.addAppender(new ConsoleAppender(
				   new PatternLayout("%-6r [%p] %c - %m%n")));
	}
		
	def "find user by username"() {
		User.metaClass.encodePassword = { -> }
		
		setup:
		mockDomain(User)

		when:
		new User(username: username, password: password).save()

		then:
		User.findByUsername(username) != null

		where:
		username = "fred"
		password = "fl1ntst0ne"
	}

	def "username not blank"() {
		setup:
		mockForConstraintsTests(User)
		mockDomain(User)

		when:
		def user = new User(username:"")
		user.validate()

		then:
		user.errors.hasFieldErrors("username")
	}
}