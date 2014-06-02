package helloworld;

import java.util.List;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
@Table(name = "taskboardcolumn")
public class TaskboardColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String myName;
    private int myLimit = 0;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "column_tasks",
            joinColumns = @JoinColumn(name = "id")
    )
    private List<Task> myTasks = new LinkedList<Task>();
    
    public Long getId()           { return id; }
    public void setId(Long value) { id = value; }

    public void setName(String value) { myName = value;}
    public String getName()           { return myName;}
    
    public int getLimit()           { return myLimit; }
    public void setLimit(int value) { myLimit = value; }


    public TaskboardColumn(String name) {
        myName = name;
    }

    public TaskboardColumn() {
    }
    
    public void addTask(Task task) {
        myTasks.add(task);
    }

    
    public void removeTask(Task task) {
        myTasks.remove(task);
    }

    
    public List<Task> getTasks() {
        // we want a copy of the list to prevent outside modification
        return new LinkedList<Task>(myTasks);
    }

}
