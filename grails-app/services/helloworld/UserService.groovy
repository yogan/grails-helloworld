package helloworld

import grails.transaction.Transactional

@Transactional
class UserService {
    def taskboardService

    def randomUser() {
        User aRandomUser = new User();
        aRandomUser.myName = "Axel";
        aRandomUser.myLogin = "AKH";
        aRandomUser.myTaskboards.add(taskboardService.randomBoard());
        return aRandomUser;
    }

    def list() {
        List<User> randomUsers = new LinkedList<User>();
        randomUsers.add(randomUser());
        return randomUsers;
    }
}
