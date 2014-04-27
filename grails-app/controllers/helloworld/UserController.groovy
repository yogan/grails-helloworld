package helloworld

class UserController {
    def userService;

    def index() {
        [users: userService.list()]
    }

    def show() {
        def curUser = userService.getUser(params.id)
        def boards = curUser != null ? curUser.myTaskboards : null
        [user: curUser, taskboards: boards]
    }

    // TODO: create ->html form
    // TODO: save
    // TODO: edit -> html form
    // TODO: update
    
    def delete() {
        log.error("deleting with " + params);
        def user = userService.getUser(params.id);
        if ( user ) {
            userService.delete(user);
            redirect action:"index", method:"GET"
        } else {
            render status: UNPROCESSABLE_ENTITY
        }
    }
    
    def login() {
        if ( params.userlogin ) {
            for (def user : userService.list()) {
                if (user.myLogin == params.userlogin) {
                    session["user"] = user.id
                    redirect(action:"show", id:user.id)
                }
            }
        }
    }

    def logout() {
        session["user"] = null
        redirect(uri:'/')
    }
}
