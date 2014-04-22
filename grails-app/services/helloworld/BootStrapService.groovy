package helloworld

class BootStrapService {

    def taskService

    def createTaskForRandomUserOnBoard(String taskname, List<User> users,
                                       Taskboard board) {
            // "random" owner, yay.
            def randomOwner = users[taskname.length() % users.size()]

            // random column, yay².
            def columns = board.getColumnNames().toArray()
            def randomColumn = columns[(int) (Math.random() * columns.length)]
            
            def task = taskService.createTask(taskname, randomOwner)
            board.addTaskToColumn(task, randomColumn)
    }

}
