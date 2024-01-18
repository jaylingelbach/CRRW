package CRRW.MyPlushie.models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String description;

//    private Set<Plushie> plushies;
//
//    @Lob
//    private byte[] profilePicture; // we can store the binary data of the image, making it easier to store in MySQL.


    public User(){}     //blank constructor
    public User(Long id, String username, String password, String description/*, Set<Plushie> plushies*/  /* , byte[] profilePicture */) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.description = description;
        //this.plushies = plushies;
//        this.profilePicture = profilePicture;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Can define roles or authorities for your user here for future usage
        // For simplicity, returns an empty list for now
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // You can implement your logic for account expiration here
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // You can implement your logic for account locking here
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // You can implement your logic for credentials expiration here
        return true;
    }

    @Override
    public boolean isEnabled() {
        // You can implement your logic for enabling/disabling the user here
        return true;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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