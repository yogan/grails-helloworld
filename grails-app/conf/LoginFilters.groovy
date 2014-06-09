class LoginFilters {
    def filters = {
        loginCheck(controller: '*') {
            before = {
                //println("---------------------------------------------")
                //println("Request.requestURI: "+request.requestURI)
                //println("Request.forwardURI: "+request.forwardURI)
                //println("Controller: "+controllerName)
                //println("ActionName: "+actionName)
                //println("USER: "+session.user)

                if (controllerName != null 
                        && !controllerName.equals('user') 
                        && !controllerName.equals('assets') 
                        && !actionName.equals('login') 
                        && null == session.user) {
                    redirect(controller: 'user', action:'login')
                    return false
                }
            }
        }
    }
}
