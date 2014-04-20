package helloworld

class UserController {
    def userService;

    def index() {
        def aUser = userService.randomUser();
        [user: aUser, taskboards: aUser.myTaskboards]
    }

    def show() {
        [user: userService.randomUser()]
    }
}
