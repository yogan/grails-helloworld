package helloworld

class TaskboardController {
    def taskService
    def taskboardService

    def index() {
        def board = taskboardService.randomBoard()

        for (task in taskService.list()) {
            board.myTasksPerColumn.get(0).add(task)
        }

        [taskboard: board]
    }
}
