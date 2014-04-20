package helloworld

class TaskboardController {
    def taskboardService

    def index() {
        [taskboard: taskboardService.list()]
    }

    def show() {
        def board = taskboardService.getBoard(params.id)
        [taskboard: board]
    }
}
