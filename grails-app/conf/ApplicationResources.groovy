modules = {
    application {
		dependsOn 'scaffolding'
		dependsOn 'iefix'
		resource url:'/images/favicon.ico'
        resource url:'js/application.js'
		resource url:'css/jumbotron.css'
		
    }
		
	iefix {
		resource url:'http://html5shim.googlecode.com/svn/trunk/html5.js',  wrapper: { s -> "<!--[if lt IE 9]>$s<![endif]-->" }, disposition: 'head'
	}
}