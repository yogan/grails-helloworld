package helloworld

import grails.transaction.Transactional

@Transactional
class UserService {
    def taskboardService


    def getUser(String idstring) {
        return getUser(Integer.parseInt(idstring))
    }
    
    def getUser(int id) {
        return User.findById(id);
    }
    
    def updateName(User aUser,String newName) {
        aUser.setName(newName);
        aUser.save();
    }
    
    def updateLogin(User aUser,String newLogin) {
        aUser.setLogin(newLogin);
        aUser.save();
    }
    
    def updatePassword(User aUser,String newPassword) {
        aUser.setPassword(newPassword);
        aUser.save();
    }


    def follow(User user,Taskboard taskboard) {
        user.myTaskboards.add(taskboard);
        user.save()
    }
    
    def unfollow(User user,Taskboard taskboard) {
        user.myTaskboards.remove(taskboard);
        user.save()
    }
    
    def createUser(String login, String name,String password) {
        User user = new User(login, name,password)
        user.save()
        return user
    }

    def list() {
        return User.list();
    }
    
    def delete(User user) {
        user.delete();
    }
}
