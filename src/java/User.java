package helloworld;

import java.util.List;
import java.util.LinkedList;

public class User {
    private static int idCounter = 0;

    public final int id;
    public String myName;
    public String myLogin;
    public String myPassword;
    public List<Taskboard> myTaskboards = new LinkedList<Taskboard>();

    public User(String login) {
        this(login, login,"");
    }

    public User(String login, String name,String password) {
        id = idCounter++;
        myLogin = login;
        myName = name;
        myPassword = password;
    }
    
    public boolean authenticate(String password) {
        return myPassword.equals(password);
    }
}
