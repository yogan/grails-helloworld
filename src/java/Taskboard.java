package helloworld;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.*;

@Entity
@Table(name = "taskboard")
public class Taskboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String myName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="name_column")
    @MapKeyColumn(name="name")
    private Map<String,TaskboardColumn> myColumns = new HashMap<String,TaskboardColumn>();

    public Taskboard(String name) {
        myName = name;
    }

    public Taskboard() {
    }

    public Long getId()           { return id; }
    public void setId(Long value) { id = value; } 
    
    public String getName()           { return myName; }
    public void setName(String value) { myName = value; }
    
    
    public TaskboardColumn addColumn(String name) {
        // TODO check existence
        TaskboardColumn column = new TaskboardColumn(name);
        myColumns.put(name, column);
        return column;
    }

    public void addColumn(String name, int limit) {
        TaskboardColumn column = addColumn(name);
        column.setLimit(limit);
    }

    public List<String> getColumnNames() {
        return new ArrayList<String>(myColumns.keySet());
    }

    public List<TaskboardColumn> getColumns() {
        return new ArrayList<TaskboardColumn>(myColumns.values());
    }

    public boolean addTaskToColumn(Task task, String columnName) {
        TaskboardColumn column = myColumns.get(columnName);
        if (column == null) {
            return false; // TODO: proper error handling
        }
        column.addTask(task);
        return true;
    }
}
