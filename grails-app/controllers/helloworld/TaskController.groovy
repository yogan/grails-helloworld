package helloworld

class TaskController {
    def taskService
    def userService

    def index() {
        [tasks: taskService.list(), taskService: taskService]
    }

    def search() {
        def matches = []
        if (params.taskName) {
            matches = Task.findAllByNameIlike("%" + params.taskName + "%")
        }
        [searchString: params.taskName, matches: matches]
    }

    def show() {
        def task = taskService.getTask(params.id)
        def user = taskService.getUserOfTask(task.id)
        [task: task, user: user]
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
            if (currentOwnerOfTask.id != params.user) {
                // FIXME: seems broken
                def user = userService.getUser(params.user)
                user.myTasks.add(task)
                currentOwnerOfTask.myTasks.remove(task)
            }
        } else {
            // new
            def user = userService.getUser(params.user)
            taskService.createTask(params.name, user)
        }
        redirect(action:"index")
    }

}
