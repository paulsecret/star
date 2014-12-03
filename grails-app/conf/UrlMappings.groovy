class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        '/coffee'(resources: 'event')
        '/ingredient'(resources: 'event')
        '/order'(resources: 'order')

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
