package spitterapp.entities;


import javax.persistence.*;


@Entity
@Table(name = "USERS")
public class SpitterEnt {

    // Map userId to primary Key with  autoincrement
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
