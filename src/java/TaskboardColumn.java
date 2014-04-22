package helloworld;

import java.util.List;
import java.util.LinkedList;

public class TaskboardColumn {

    public String myName;

    private List<Task> myTasks;

    public TaskboardColumn(String name) {
        myName = name;
        myTasks = new LinkedList<Task>();
    }

    public void addTask(Task task) {
        myTasks.add(task);
    }

    public List<Task> getTasks() {
        // we want a copy of the list to prevent outside modification
        return new LinkedList<Task>(myTasks);
    }

}