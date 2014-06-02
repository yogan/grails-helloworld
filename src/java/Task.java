package helloworld;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    private Long id;
    private String myName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()           { return id; }
    public void setId(Long value) { id = value; }

    public String getName()           { return myName; }
    public void setName(String value) { myName = value; }
}
