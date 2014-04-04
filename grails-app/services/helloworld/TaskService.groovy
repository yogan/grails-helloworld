package helloworld

import grails.transaction.Transactional

@Transactional
class TaskService {

    def list() {
        Set<String> tasks = new HashSet<String>()
        tasks.add("foo")
        tasks.add("bar")
        return tasks
    }
}
