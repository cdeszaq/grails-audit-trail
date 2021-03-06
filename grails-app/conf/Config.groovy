import static grails.util.Environment.*

	log4j = {
	    // Example of changing the log pattern for the default console
	    // appender:
	    //
	    //appenders {
	    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
	    //}

	    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
	           'org.codehaus.groovy.grails.web.pages', //  GSP
	           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
	           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
	           'org.codehaus.groovy.grails.web.mapping', // URL mapping
	           'org.codehaus.groovy.grails.commons', // core / classloading
	           'org.codehaus.groovy.grails.plugins', // plugins
	           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
	           'org.springframework',
	           'org.hibernate',
	           'net.sf.ehcache.hibernate'

	    warn   'org.mortbay.log'
	}



grails.gorm.default.mapping = {
	id column: 'OID', generator:'native'
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'nine.tests.TestUser'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'nine.tests.TestUserTestRole'
grails.plugins.springsecurity.authority.className = 'nine.tests.TestRole'

grails{
	plugin{
		audittrail{			
			createdBy.field  = "createdBy"
			createdBy.type   = "java.lang.Long" //fully qualified class name if not a java.lang.(String,Long,etc..)
			
			createdDate{
				field = "createdDate" //
				type  = "java.util.Date" //the class name type
			}
			//Will try a joda time on this one
			editedDate.field  = "editedDate"//date edited
			
			editedBy.field  = "updatedBy" //id who updated/edited
			editedBy.type   = "java.lang.Long" //fully qualified class name if not a java.lang.(String,Long,etc..)
			editedBy.constraints = "nullable:true, max:90000l"
			editedBy.mapping = "column: 'whoUpdated'"
			
			companyId.field   = "companyId" //used for multi-tenant apps
		}
	}
}

