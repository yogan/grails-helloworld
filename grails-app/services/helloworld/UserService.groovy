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
        user.myName = newName;
    }
    
    def updateLogin(User aUser,String newLogin) {
        user.myName = newLogin;
    }
    
    def getUser(int id) {
        for (def user : userCache) {
            if (user.id == id) {
                return user
            }
        }
        return null // FIXME: OMG.
    }

    def createUser(String login, String name) {
        User user = new User(login, name)
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
