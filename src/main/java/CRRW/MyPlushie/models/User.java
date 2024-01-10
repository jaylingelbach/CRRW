package CRRW.MyPlushie.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

// TODO: restore set<Plushie> when setting up all fields for use in MySQL with annotations and relations.
// TODO: restore profilephoto later, got too many errors trying to use it this early

    @OneToMany
    @JoinColumn (name= "user_id")
    private List<Plushie> plushies =new ArrayList<>();
//
//    private byte[] profilephoto; // we can store the binary data of the image, making it easier to store in MySQL.
    

    public User(){}     //blank constructor
    public User(Long id, String username, String password, List<Plushie> plushies  /*, byte[] profilephoto*/) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.plushies = plushies;
//        this.profilephoto = profilephoto;
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

    public List<Plushie> getPlushies()
    {
    return plushies;
    }

    public void setPlushies(List<Plushie> plushies) {
        this.plushies = plushies;
    }

//    public byte[] getPhoto() {
//        return profilephoto;
//    }
//
//    public void setPhoto(byte[] profilephoto) {
//        this.profilephoto = profilephoto;
//    }
}