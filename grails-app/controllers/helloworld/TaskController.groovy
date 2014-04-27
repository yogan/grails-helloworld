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

    def delete() {
        if (params.id) {
            [task: taskService.deleteTask(params.id)]
        }
        redirect(action:"index")
    }

    def edit() {
        def task = null
        def userid = session["user"]
        if (params.id) {
            task = taskService.getTask(params.id)
            userid = task.myOwner.id
        }
        [task: task, users: userService.list(), defaultUserId: userid]
    }

    def save() {
        // TODO error handling
        if (params.id) {
            // edit
            def task = taskService.getTask(params.id)
            task.myName = params.name
            if (task.myOwner.id != params.owner) {
                def user = userService.getUser(params.owner)
                task.myOwner = user
            }
        } else {
            // new
            def user = userService.getUser(params.owner)
            taskService.createTask(params.name, user)
        }
        redirect(action:"index")
    }

}
