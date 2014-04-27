package helloworld

import org.springframework.web.context.request.RequestContextHolder

import spock.lang.*

/**
 *
 */
class UserSpec extends Specification {
    def userService
  
    def setup() {
    }
    
    def cleanup() {
    }

    void "test that login stores user in session object"() {
        given:
        def controller = new UserController();
        String login = "aLogin";
        String name = "aName";
        def testUser = userService.createUser(login,name);
        
        when:
        controller.params.userlogin = login;
        controller.login();
        
        then: 
        assert testUser.id == RequestContextHolder.currentRequestAttributes().getSession().user
        
        when:
        controller.response.reset();
        controller.logout();
        
        then:
        assert null == RequestContextHolder.currentRequestAttributes().session.user
    }
}
