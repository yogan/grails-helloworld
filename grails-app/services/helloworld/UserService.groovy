package helloworld

import grails.transaction.Transactional

@Transactional
class UserService {

    def list() {
		List<User> randomUsers = new LinkedList<User>();
		User aRandomUser = new User();
		aRandomUser.myName = "Axel";
		aRandomUser.myLogin = "AKH";
		randomUsers.add(aRandomUser);
		return randomUsers;
    }
}
