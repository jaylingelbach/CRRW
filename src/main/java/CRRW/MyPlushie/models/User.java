package CRRW.MyPlushie.models;
import javax.persistence.*;

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

//    private Set<Plushie> plushies;
//
//    @Lob
//    private byte[] profilePicture; // we can store the binary data of the image, making it easier to store in MySQL.
    

    public User(){}     //blank constructor
    public User(Long id, String username, String password/*, Set<Plushie> plushies*/  /* , byte[] profilePicture */) {
        this.id = id;
        this.username = username;
        this.password = password;
        //this.plushies = plushies;
//        this.profilePicture = profilePicture;
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

//    public Set<Plushie> getPlushies() {
//        return plushies;
//    }
//
//    public void setPlushies(Set<Plushie> plushies) {
//        this.plushies = plushies;
//    }
//    public byte[] getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(byte[] profilePicture) {
//        this.profilePicture = profilePicture;
//    }
}