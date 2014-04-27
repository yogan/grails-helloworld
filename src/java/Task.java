package helloworld;

public class Task {
    private static int idCounter = 0;

    public final int id;
    public String myName;
    public User myOwner;

    public Task (String name) {
        this(idCounter++, name);
    }

    public Task (int id, String name) {
        this.id = id;
        myName = name;
    }
}
