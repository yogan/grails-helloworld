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

        board.myColumns.put(0,"To Do")
        board.myTasksPerColumn.put(0,new LinkedList<Task>())
        board.myColumns.put(1,"Doing")
        board.myTasksPerColumn.put(1,new LinkedList<Task>())
        board.myColumns.put(2,"Done")
        board.myTasksPerColumn.put(2,new LinkedList<Task>())

        boardCache.add(board)
        return board
    }
}
