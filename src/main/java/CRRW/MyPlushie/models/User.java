package CRRW.MyPlushie.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private Set<Plushie> plushies;

    private byte[] photo; // we can store the binary data of the image, making it easier to store in MySQL.


// TODO: make constructor after putting in all nessessary things


    public User(){}     //blank constructor
    public User(Long id, String username, String password, Set<Plushie> plushies, byte[] photo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.plushies = plushies;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Plushie> getPlushies() {
        return plushies;
    }

    public void setPlushies(Set<Plushie> plushies) {
        this.plushies = plushies;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}