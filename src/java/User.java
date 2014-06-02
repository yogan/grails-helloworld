package helloworld;

import java.util.List;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
@Table(name = "userEntity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String login;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_tasks")
    private List<Task> myTasks = new LinkedList<Task>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="users_taskboards",
    joinColumns = @JoinColumn(name = "userEntity"),
    inverseJoinColumns = @JoinColumn(name = "taskboard"))
    private List<Taskboard> myTaskboards = new LinkedList<Taskboard>();

    public User(String login) {
        this(login, login,"");
    }

    public User() {
    }
    
    public User(String login, String name,String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }
    
    public List<Taskboard> getTaskboards() {
        return new LinkedList<Taskboard>(myTaskboards);
    }
    
    public List<Task> getTasks() {
        return new LinkedList<Task>(myTasks);
    }
    
    public Long getId()           { return id; }
    public void setId(Long value) { id = value; }
    
    public String getName()           { return name; }
    public void setName(String value) {  name = value; }
    
    public String getPassword()           { return password; }
    public void setPassword(String value) { password = value; }
    
    public String getLogin()           { return login; }
    public void setLogin(String value) { login = value; } 
    
    public boolean authenticate(String password) {
        return getPassword().equals(password);
    }
}
