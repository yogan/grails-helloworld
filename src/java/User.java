package helloworld;

import java.util.List;
import java.util.LinkedList;

public class User {
    private static int idCounter = 0;

    public final int id;
    public String myName;
    public String myLogin;
    public List<Taskboard> myTaskboards = new LinkedList<Taskboard>();

    public User(String login) {
        this(login, login);
    }

    public User(String login, String name) {
        id = idCounter++;
        myLogin = login;
        myName = name;
    }
}
