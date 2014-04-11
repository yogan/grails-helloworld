package helloworld

class TaskboardController {
    def taskService
    def taskboardService
    def userService

    def index() {
        def board = taskboardService.randomBoard()
        def user = userService.randomUser()

        for (task in taskService.list()) {
            task.myOwner = user
            board.myTasksPerColumn.get(0).add(task)
        }

        [taskboard: board]
    }
}
