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
	
	def login() {
		if ( params.userlogin ) {
			for (def user : userService.list()) {
				if (user.myLogin == params.userlogin) {
					session["user"] = user.id;
					redirect(action:"show",id:user.id);	
				}
			}
        }
	}
}
