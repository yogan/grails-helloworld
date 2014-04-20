package helloworld

import grails.transaction.Transactional

@Transactional
class TaskService {

    private List<Task> taskCache = new LinkedList<Task>()

    def list() {
        return taskCache
    }

    def createTask(String title, User owner) {
        def task = new Task(title)
        task.myOwner = owner
        taskCache.add(task)
        return task
    }
}
