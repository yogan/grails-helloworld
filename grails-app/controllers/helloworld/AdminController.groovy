package helloworld

class AdminController {
    def userService;
    def taskboardService;

    def index() { 
        [users: userService.list(),taskboards:taskboardService.list()]
    }
}
