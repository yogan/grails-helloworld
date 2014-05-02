package helloworld

class AdminController {
    def userService;
    def taskboardService;

    def index() { 
        def taskboards = new LinkedList<Taskboard>();
        for (def taskboard : taskboardService.list()) {
            boolean usedByAnyUser = false;
            for ( def user : userService.list() ) {
                if  (user.myTaskboards.contains(taskboard) ) {
                    usedByAnyUser = true;
                }
            }
            
            if ( ! usedByAnyUser ) {
                taskboards.add( taskboard );
            }
        }
        [users: userService.list(),taskboards:taskboards]
    }
}
