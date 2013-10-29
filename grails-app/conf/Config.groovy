// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
	all:           '*/*',
	atom:          'application/atom+xml',
	css:           'text/css',
	csv:           'text/csv',
	form:          'application/x-www-form-urlencoded',
	html:          [
		'text/html',
		'application/xhtml+xml'
	],
	js:            'text/javascript',
	json:          [
		'application/json',
		'text/json'
	],
	multipartForm: 'multipart/form-data',
	rss:           'application/rss+xml',
	text:          'text/plain',
	xml:           [
		'text/xml',
		'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = [
	'/images/*',
	'/css/*',
	'/js/*',
	'/plugins/*'
]

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
grails.sitemesh.default.layout = application.gsp

// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
	development {
	}
	production {
	}
}

environments {

	development {
		grails.logging.jul.usebridge = true
		// log4j configuration
		log4j = {
			appenders {
				file name: 'grailsfile',	file: 'target/grails.log'
				file name: 'rootlog', 		file: 'target/root.log'
				file name: 'devfile',		file: 'target/development.log',
				layout: pattern(conversionPattern: "[%d{HH:mm:ss:SSS}] %-5p %c{2}: %m%n")
			}
			root { error 'stdout', 'rootlog' }
			debug additivity: false, grailsfile: [
				'org.codehaus.groovy.grails.web.servlet',        // controllers
				'org.codehaus.groovy.grails.web.pages',          // GSP
				'org.codehaus.groovy.grails.web.sitemesh',       // layouts
				'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
				'org.codehaus.groovy.grails.web.mapping',        // URL mapping
				'org.codehaus.groovy.grails.commons',            // core / classloading
				'org.codehaus.groovy.grails.plugins',            // plugins
				'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
				'org.springframework',
				'org.hibernate',
				'net.sf.ehcache.hibernate'
			]
			debug additivity: false, devfile: [
				'ie.koala.dontforget.DebugFilters'
			]
		}
	}

	test {
		log4j = {
			appenders {
				file name: 'grailsfile',	file: 'target/grails.log'
				file name: 'rootlog',		file: 'target/root.log'
				file name: 'testfile',		file: 'target/test.log',
				layout: pattern(conversionPattern: "[%d{HH:mm:ss:SSS}] %-5p %c{2}: %m%n")
			}
			root { error 'stdout', 'rootlog' }
			info additivity: false, grailsfile: [
				'org.codehaus.groovy.grails.web.servlet',        // controllers
				'org.codehaus.groovy.grails.web.pages',          // GSP
				'org.codehaus.groovy.grails.web.sitemesh',       // layouts
				'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
				'org.codehaus.groovy.grails.web.mapping',        // URL mapping
				'org.codehaus.groovy.grails.commons',            // core / classloading
				'org.codehaus.groovy.grails.plugins',            // plugins
				'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
				'org.springframework',
				'org.hibernate',
				'net.sf.ehcache.hibernate'
			]
			all additivity: false, testfile: [
				'ie.koala.dontforget.DebugFilters'
			]

		}
	}
	production {
		grails.logging.jul.usebridge = false
		// TODO: grails.serverURL = "http://www.changeme.com"
		grails.logging.jul.usebridge = false
		log4j = {
			appenders {
				file name: 'grailsfile',	file: 'target/grails.log'
				file name: 'rootlog',		file: 'target/root.log'
				file name: 'prodfile',		file: 'target/prod.log',
				layout: pattern(conversionPattern: "[%d{HH:mm:ss:SSS}] %-5p %c{2}: %m%n")
			}
			root { error 'stdout', 'rootlog' }
			error additivity: false, grailsfile: [
				'org.codehaus.groovy.grails.web.servlet',        // controllers
				'org.codehaus.groovy.grails.web.pages',          // GSP
				'org.codehaus.groovy.grails.web.sitemesh',       // layouts
				'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
				'org.codehaus.groovy.grails.web.mapping',        // URL mapping
				'org.codehaus.groovy.grails.commons',            // core / classloading
				'org.codehaus.groovy.grails.plugins',            // plugins
				'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
				'org.springframework',
				'org.hibernate',
				'net.sf.ehcache.hibernate'
			]
			debug additivity: false, devfile: [
				'ie.koala.dontforget.DebugFilters'
			]
		}
	}
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'ie.koala.dontforget.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'ie.koala.dontforget.UserRole'
grails.plugin.springsecurity.authority.className = 'ie.koala.dontforget.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['permitAll'],
	'/index':                         ['permitAll'],
	'/index.gsp':                     ['permitAll'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
	'/**/favicon.ico':                ['permitAll']]

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/reminder'
