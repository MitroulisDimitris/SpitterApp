package spitterapp.model;

import java.util.ArrayList;
import java.util.List;

public class Spitter {
    private int id;
    private String fisrtName;
    private String lastName;
    private String password;
    private List<Spittle> spittles;

    public Spitter(int id, String fisrtName, String lastName, String password) {
        this.id = id;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.password = password;
        this.spittles = new ArrayList<>();

    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;

    }

    public void addSpittle(Spittle spittle) {
        this.spittles.add(spittle);
    }
    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id+
                ",fname = "+ fisrtName + '\''+
                ",lname = "+ lastName + '\''+
                ",spittles = "+spittles.size()+
                "}";
    }
}

