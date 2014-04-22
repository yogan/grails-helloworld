package helloworld

import grails.transaction.Transactional

@Transactional
class TaskboardService {

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

    def createBoard(String name) {
        def board = new Taskboard(name)
        boardCache.add(board)
        return board
    }
}
