class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/user/login"(controller:'user',action:'login')
		"/user"(resources:'user')
		
		
        "/"(view:"/index")
        "500"(view:'/error')
    }
}
