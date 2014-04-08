package helloworld

import grails.transaction.Transactional

@Transactional
class TaskboardService {
		
    def randomBoard() {
		if ( null == aRandomBoard ) {
			initializeRandomBoard();
		}
		return aRandomBoard;
    }
	
	private void initializeRandomBoard() {
	    aRandomBoard = new Taskboard();
		aRandomBoard.myColumns.put(0,"To Do");
		aRandomBoard.myTasksPerColumn.put(0,new LinkedList<Task>());
		aRandomBoard.myColumns.put(1,"Doing");
		aRandomBoard.myTasksPerColumn.put(1,new LinkedList<Task>());
		aRandomBoard.myColumns.put(2,"Done");
		aRandomBoard.myTasksPerColumn.put(2,new LinkedList<Task>());
		
		Task randomTask = new Task();
		randomTask.myName = "implement me";
		
		aRandomBoard.myTasksPerColumn.get(0).add(randomTask);
	}
	
	private Taskboard aRandomBoard;
}
