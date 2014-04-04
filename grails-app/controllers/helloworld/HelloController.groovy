package helloworld

class HelloController {
    def taskService

    def index() {
        [tasks: taskService.list()]
    }

    def show() {
        render params.id
    }

}
