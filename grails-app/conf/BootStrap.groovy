class BootStrap {

    def bootStrapService
    def taskboardService
    def userService

    def init = { servletContext ->
        def akh = userService.createUser("akh", "Axel","")
        def fbr = userService.createUser("fbr", "Frank","z§tPPq@1")

        def grailsBoard = taskboardService.createBoard("Awesome Grails Project",fbr)
        akh.myTaskboards.add(grailsBoard);
        grailsBoard.addColumn("To Do", 20);
        grailsBoard.addColumn("In Work", 7);
        grailsBoard.addColumn("Done");

        def boringBoard = taskboardService.createBoard("Boring Things",fbr)
        boringBoard.addColumn("Thinking About", 10);
        boringBoard.addColumn("Doing", 3);
        boringBoard.addColumn("Done");
        boringBoard.addColumn("Will Never Do");

        ["Setup environment",
         "Create default app",
         "Implement controllers",
         "Implement data model",
         "Write unit tests"
        ].each {
            bootStrapService.createTaskForRandomUserOnBoard(it, [akh,fbr], grailsBoard)
        }

        ["Dumm schauen",
         "Schlau daherreden"
        ].each {
            bootStrapService.createTaskForRandomUserOnBoard(it, [akh,fbr], boringBoard)
        }
    }

    def destroy = {
    }
}
