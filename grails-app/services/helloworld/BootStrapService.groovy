package helloworld

class BootStrapService {

    def taskService

    def createTaskForRandomUserOnBoard(String taskname, List<User> users,
                                       Taskboard board) {
            // "random", yay.
            def owner = users[taskname.length() % users.size()]
            def task = taskService.createTask(taskname, owner)
            board.addTaskToColumn(task, 0)
    }

}
