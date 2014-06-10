class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/user/login"(controller:'user',action:'login')
        "/user/logout"(controller:'user',action:'logout')
        "/user/unfollow"(controller:'user',action:'unfollow')
        "/user"(resources:'user')

        "/taskboard"(resources:'taskboard')

        "/task/search"     (controller:'task', action:'search')
        "/task/search.json"(controller:'task', action:'searchJSON')

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
