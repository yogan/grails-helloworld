package helloworld;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Taskboard {
    private static int idCounter = 0;

    public final int id;
    public String myName;

    private Map<String,TaskboardColumn> myColumns;

    public Taskboard(String name) {
        id = idCounter++;
        myName = name;
        myColumns = new HashMap<String,TaskboardColumn>();
    }

    public TaskboardColumn addColumn(String name) {
        // TODO check existance
        TaskboardColumn column = new TaskboardColumn(name);
        myColumns.put(name, column);
        return column;
    }

    public void addColumn(String name, int limit) {
        TaskboardColumn column = addColumn(name);
        column.limit = limit;
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
