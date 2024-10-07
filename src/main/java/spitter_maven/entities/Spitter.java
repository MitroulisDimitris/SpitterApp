package spitter_maven.entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Spitter")
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "firstName", nullable = false,length = 50)
    private String firstName;

    @Column(name = "lastName", nullable = false,length = 50)
    private String lastName;

    @Column(name = "password", nullable = false,length = 50)
    private String password;

    // cascade -> operations are preformed on the child as well
    // orhpanRemoval -> delete childs in case tha parent gets deleted
    @OneToMany(mappedBy = "spitter",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Spittle> spittleList;

    public Spitter(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Spitter() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
}
