package helloworld

class TaskboardController {
	def taskboardService
	
    def index() { 
		[taskboard: taskboardService.randomBoard()]
	}
}
