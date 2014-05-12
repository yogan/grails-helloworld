package helloworld;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String myName;
    public String getMyName() { return myName; }
    public void setMyName(String value) { myName = value; }
}
