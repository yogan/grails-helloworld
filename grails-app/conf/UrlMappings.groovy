class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/user/login"(controller:'user',action:'login')
        "/user/logout"(controller:'user',action:'logout')
        "/user"(resources:'user')

        "/taskboard"(resources:'taskboard')

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
