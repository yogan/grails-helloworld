package helloworld;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Taskboard {
    private static int idCounter = 0;

    public final int id;
    public String myName;
    public Map<Integer,String> myColumns = new HashMap<Integer,String>();
    public Map<Integer,List<Task>> myTasksPerColumn = new HashMap<Integer,List<Task>>();

    public Taskboard(String name) {
        id = idCounter++;
        myName = name;
    }

    public List<String> columnNames() {
        List<String> result = new LinkedList<String>(); 
        for (Map.Entry<Integer, String> entry : myColumns.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public boolean addTaskToColumn(Task task, int col) {
        List<Task> tasksInColumn = myTasksPerColumn.get(col);
        if (tasksInColumn == null) {
            return false; // TODO: proper error handling
        }
        tasksInColumn.add(task);
        return true;
    }

}
