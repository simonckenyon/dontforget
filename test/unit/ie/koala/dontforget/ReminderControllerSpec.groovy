package ie.koala.dontforget

import grails.test.mixin.*

import org.apache.log4j.ConsoleAppender
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.PatternLayout

import spock.lang.Specification

@TestFor(ReminderController)
class ReminderControllerSpec extends Specification {
	static
	{
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.WARN);
		rootLogger.addAppender(new ConsoleAppender(
				   new PatternLayout("%-6r [%p] %c - %m%n")));
	}
		
	def "index action should redirect to list page"() {
		when: controller.index()

		then: response.redirectedUrl == "/reminder/list"
	}
}