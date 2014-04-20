class BootStrap {

    def taskService
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

        List<String> grailsTasks = Arrays.asList(
                "Setup environment",
                "Create default app",
                "Implement controllers",
                "Implement data model",
                "Write unit tests")

        for (def taskName : grailsTasks) {
            // "random" owner
            def owner = taskName.length() % 2 ? akh : fbr
            def task = taskService.createTask(taskName, owner)
            // FIXME: add proper API for add to column
            grailsBoard.myTasksPerColumn.get(0).add(task)
        }

        List<String> boringTasks = Arrays.asList(
                "Dumm schauen",
                "Schlau daherreden")

        for (def taskName : boringTasks) {
            def owner = taskName.length() % 2 ? akh : fbr
            def task = taskService.createTask(taskName, owner)
            // FIXME: add proper API for add to column
            boringBoard.myTasksPerColumn.get(0).add(task)
        }
    }

    def destroy = {
    }
}
