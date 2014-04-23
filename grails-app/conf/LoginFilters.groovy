class LoginFilters {
   def filters = {
        loginCheck(controller: '*') {
           before = {
              if (!controllerName.equals('user') && !actionName.equals('login') && session["user"] == null) {			  
                  redirect(controller: 'user', action:'login')
                  return false
               }
           }
       }
   }
}