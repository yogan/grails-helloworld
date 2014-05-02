package helloworld

import grails.transaction.Transactional

@Transactional
class UserService {
    def taskboardService

    private List<User> userCache;

    public UserService() {
        userCache = new LinkedList<User>()
    }

    def getUser(String idstring) {
        return getUser(Integer.parseInt(idstring))
    }

    def updateName(User aUser,String newName) {
        aUser.myName = newName;
    }
    
    def updateLogin(User aUser,String newLogin) {
        aUser.myName = newLogin;
    }
    
    def updatePassword(User aUser,String newPassword) {
        aUser.myPassword = newPassword;
    }
    
    def getUser(int id) {
        for (def user : userCache) {
            if (user.id == id) {
                return user
            }
        }
        return null // FIXME: OMG.
    }

    def follow(User user,Taskboard taskboard) {
        user.myTaskboards.add(taskboard);
    }
    
    def unfollow(User user,Taskboard taskboard) {
        user.myTaskboards.remove(taskboard);
    }
    
    def createUser(String login, String name,String password) {
        User user = new User(login, name,password)
        userCache.add(user)
        return user
    }

    def list() {
        return userCache
    }
    
    def delete(User user) {
        userCache.remove(user);
    }
}
