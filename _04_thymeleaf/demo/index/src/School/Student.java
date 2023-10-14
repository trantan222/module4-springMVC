package School;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    public Student(String name, String id) {
        super(name);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }
}

