package helloworld

import grails.transaction.Transactional

@Transactional
class TaskService {

    def list() {
        List<Task> tasks = new LinkedList<Task>()
        addRandomTasks(tasks)
        return tasks
    }

    def addRandomTasks(tasks) {
        tasks.add(new Task("Dinge tun"))
        tasks.add(new Task("Grails coden"))
        tasks.add(new Task("dumm schauen"))
    }
}
