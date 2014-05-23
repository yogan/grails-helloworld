package helloworld

import grails.transaction.Transactional

@Transactional
class TaskService {

    def userService

    def list() {
        return Task.getAll()
    }

    def getTask(String idstring) {
        int id = Integer.parseInt(idstring)
        return Task.get(id)
    }

    def createTask(String title, User owner) {
        def task = new Task()
        task.setMyName(title)
        task.save()
        owner.myTasks.add(task)
        return task
    }

    def deleteTask(String idstring) {
        def task = getTask(idstring)
        task.delete()
    }

    def getUserOfTask(Long taskId) {
        def allUsers = userService.list()
        for (User user : allUsers) {
            for (def task : user.myTasks) {
                if (task.id == taskId) {
                    return user
                }
            }
        }
        return null
    }
}
