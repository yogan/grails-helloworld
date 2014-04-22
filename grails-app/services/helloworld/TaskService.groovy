package helloworld

import grails.transaction.Transactional

@Transactional
class TaskService {

    private List<Task> taskCache = new LinkedList<Task>()

    def list() {
        return taskCache
    }

    def getTask(String idstring) {
        int id = Integer.parseInt(idstring)
        for (def task : taskCache) {
            if (task.id == id) {
                return task
            }
        }
        return null // FIXME: OMG.
    }

    def createTask(String title, User owner) {
        def task = new Task(title)
        task.myOwner = owner
        taskCache.add(task)
        return task
    }
}
