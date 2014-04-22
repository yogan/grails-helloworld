package helloworld

class TaskboardController {
    def taskboardService

    def index() {
        [taskboards: taskboardService.list()]
    }

    def show() {
        def board = taskboardService.getBoard(params.id)
        [taskboard: board, columns: board.getColumns()]
    }
}
