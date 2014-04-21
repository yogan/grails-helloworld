class BootStrap {

    def bootStrapService
    def taskboardService
    def userService

    def init = { servletContext ->
        def grailsBoard = taskboardService.createBoard("Awesome Grails Project")
        def boringBoard = taskboardService.createBoard("Boring Things")

        def akh = userService.createUser("akh", "Axel")
        def fbr = userService.createUser("fbr", "Frank")

        akh.myTaskboards.add(grailsBoard)
        fbr.myTaskboards.add(grailsBoard)
        fbr.myTaskboards.add(boringBoard)

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
