package helloworld

class TaskController {
    def taskService
    def userService

    def index() {
        [tasks: taskService.list()]
    }

    def show() {
        [task: taskService.getTask(params.id)]
    }

    def edit() {
        if (params.id) {
            [task: taskService.getTask(params.id)]
        }
    }

    def save() {
        if (params.id) {
            def task = taskService.getTask(params.id)
            task.myName = params.name
        } else {
            // TODO error handling
            def user = userService.getUser(session["user"])
            taskService.createTask(params.name, user)
        }
        redirect(action:"index")
    }

}
