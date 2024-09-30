package spitterapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Spitter {
    private int id;
    private String fname;
    private String lname;
    private String password;
    private List<Spittle> spittles;

    public Spitter(int id,String fname,  String lname, String password) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.spittles = new ArrayList<>();

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
                ",fname = "+fname+ '\''+
                ",lname = "+lname+ '\''+
                ",spittles = "+spittles.size()+
                "}";
    }
}

