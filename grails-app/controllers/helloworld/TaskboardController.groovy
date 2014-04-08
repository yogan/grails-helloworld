package helloworld

class TaskboardController {
	def taskboardService
	
    def index() { 
		[taskboard: taskboardService.randomBoard()]
	}
	
	def addTask() {
		def randomTaskBoard = taskboardService.randomBoard();
		def newTask = new Task();
		newTask.myName = params.name;
		Integer column = 0;
	    taskboardService.addTask(randomTaskBoard,column,newTask);
		redirect(action:index());
	}
}
