package helloworld

class TaskController {
    def taskService
    def userService

    def index() {
        [tasks: taskService.list()]
    }

    def show() {
        def task = taskService.getTask(params.id)
        def owner = taskService.getUserOfTask(task.id)
        [task: task, user: owner]
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
            userid = taskService.getUserOfTask(task.id)?.id
        }
        [task: task, users: userService.list(), defaultUserId: userid]
    }

    def save() {
        // TODO error handling
        if (params.id) {
            // edit
            def task = taskService.getTask(params.id)
            task.myName = params.name
            def currentOwnerOfTask = taskService.getUserOfTask(task.id)
            if (currentOwnerOfTask.id != params.owner) {
                def user = userService.getUser(params.owner)
                user.myTasks.Add(task)
                currentOwnerOfTask.myTasks.Remove(task)
            }
        } else {
            // new
            def user = userService.getUser(params.owner)
            taskService.createTask(params.name, user)
        }
        redirect(action:"index")
    }

}
