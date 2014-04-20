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
}
