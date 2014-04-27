package helloworld

class TaskController {
    def taskService

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
        def task
        if (params.id) {
            task = taskService.getTask(params.id)
            task.myName = params.name
        } else {
            task = new Task(param.name)
        }
        redirect(action:"index")
    }

}
