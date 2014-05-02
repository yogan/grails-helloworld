package helloworld

import grails.transaction.Transactional

@Transactional
class TaskboardService {
    def userService
    
    private List<Taskboard> boardCache = new LinkedList<Taskboard>()

    def list() {
        return boardCache
    }

    def getBoard(String idstring) {
        int id = Integer.parseInt(idstring)
        for (def board : boardCache) {
            if (board.id == id) {
                return board
            }
        }
        return null // FIXME: OMG.
    }

    def createBoard(String name,User user) {
        def board = new Taskboard(name)
        boardCache.add(board)
        userService.follow(user,board);
        return board
    }
    
    def deleteBoard(Taskboard taskboard) {
        boardCache.remove(taskboard)
        for (def user : userService.list()) {
            user.myTaskboards.remove(taskboard);
        }
    }
}
