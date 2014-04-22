package helloworld

class TaskController {
    def taskService

    def index() {
        [tasks: taskService.list()]
    }

    def show() {
        [task: taskService.getTask(params.id)]
    }

}
