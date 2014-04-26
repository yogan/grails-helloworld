class LoginFilters {
    def filters = {
        loginCheck(controller: '*') {
            before = {
                if (controllerName != null && !controllerName.equals('user') && !actionName.equals('login') && !session.user) {
                    redirect(controller: 'user', action:'login')
                        return false
                }
            }
        }
    }
}
