package helloworld

import grails.transaction.*;

class UserController {
    def userService;
    def taskboardService;
    
    def index() {
        [users: userService.list()]
    }

    def show() {
        def curUser = userService.getUser(params.id)
        def boards = curUser != null ? curUser.getTaskboards() : null
        [user: curUser, taskboards: boards]
    }

    def create() {
    }
    
    def save() {
        def user = userService.createUser(params.userlogin,params.username,params.password);
        redirect(action:"show", params:[id:user.getId()]);
    }
    
    def unfollow() {
        def user = userService.getUser(session.user);
        def board = taskboardService.getBoard(params.id);
        userService.unfollow(user,board);
        redirect(action:"show", params:[id:user.getId()]);
    }
    
    @Transactional
    def update() {
        def user = userService.getUser(params.id);
        if ( params.userlogin ) {
            userService.updateLogin(user,params.userlogin);
        }
        if ( params.username ) {
            userService.updateName(user,params.username);
        }
        if ( params.password ) {
            userService.updatePassword(user,params.password);
        }
        redirect(action:"show",params:[id:params.id]);
    }
    
    def delete() {
        def user = userService.getUser(params.id);
        if ( user ) {
            userService.delete(user);
            redirect action:"index", method:"GET"
        } else {
            render status: UNPROCESSABLE_ENTITY
        }
    }
    
    def login() {
        if ( params.userlogin ) {
            for (def user : userService.list()) {
                if (user.getLogin().equals(params.userlogin) && user.authenticate(params.password)) {
                    session.user = user.getId()
                    redirect(action:"show", id:user.getId())
                }
            }
        }
    }

    def logout() {
        session["user"] = null
        redirect(uri:'/')
    }
}
