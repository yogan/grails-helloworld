package helloworld

class TaskboardController {
    def taskboardService
    def userService
    
    def index() {
        [taskboards: taskboardService.list()]
    }

    def show() {
        def board = taskboardService.getBoard(params.id)
        [taskboard: board, columns: board.getColumns()]
    }
    
    def save() {
        def curUser = userService.getUser(session.user);
        def board = taskboardService.createBoard(params.name,curUser);
        redirect(action:"show", params:[id:board.id]);
    }
}
