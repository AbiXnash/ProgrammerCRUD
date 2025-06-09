package main;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Programmer {
    @Id private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
