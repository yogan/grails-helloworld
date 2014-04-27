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

    def create() {
    }
    
    def save() {
        def user = userService.createUser(params.userlogin,params.username);
        redirect(action:"show", params:[id:user.id]);
    }
    
    // TODO: edit -> html form
    // TODO: update
    
    def delete() {
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
