dataSource {
	pooled = true
	
	// mysql
//	driverClassName = "com.mysql.jdbc.Driver"
//	username = "dontforget"
//	password = "d0ntf0rg3t"
//	dbCreate = "update"
//	properties {
//		validationQuery="select 1"
//		testWhileIdle=true
//		timeBetweenEvictionRunsMillis=60000
//	}

	// h2
	driverClassName = "org.h2.Driver"
	username = "sa"
	password = ""


}

hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.region.factory_class = "net.sf.ehcache.hibernate.EhCacheRegionFactory"
	//	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	connection.zeroDateTimeBehavior=convertToNull
}

// environment specific settings
environments {
    development {
        dataSource {
//			url = "jdbc:mysql://127.0.0.1:3306/dontforget_dev?autoreconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
			dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
//			url = "jdbc:mysql://127.0.0.1:3306/dontforget_test?autoreconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
			dbCreate = "update"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
//			url = "jdbc:mysql://127.0.0.1:3306/dontforget?autoreconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
			dbCreate = "update"
			url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			properties {
				maxActive = -1
				minEvictableIdleTimeMillis=1800000
				timeBetweenEvictionRunsMillis=1800000
				numTestsPerEvictionRun=3
				testOnBorrow=true
				testWhileIdle=true
				testOnReturn=true
				validationQuery="SELECT 1"
			}
        }
    }
}
