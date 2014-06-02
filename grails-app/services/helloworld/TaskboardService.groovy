package helloworld

import grails.transaction.Transactional

@Transactional
class TaskboardService {
    def userService

    def list() {
        return Taskboard.list();
    }
    
    def getBoard(String idstring) {
        return Taskboard.findById(idstring);
    }

    def createBoard(String name,User user) {
        def board = new Taskboard(name)
        board.save()
        userService.follow(user,board);
        return board
    }
    
    def deleteBoard(Taskboard taskboard) {
        for (def user : userService.list()) {
            user.myTaskboards.remove(taskboard);
        }
        taskboard.delete()
    }
}
