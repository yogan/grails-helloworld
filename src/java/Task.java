package helloworld;

public class Task {
    private static int idCounter = 0;

    public final int id;
    public String myName;
    public User myOwner;

    public Task (String name) {
        id = idCounter++;
        myName = name;
    }
}
