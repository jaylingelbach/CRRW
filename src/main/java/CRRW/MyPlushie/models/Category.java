package CRRW.MyPlushie.models;

//import javax.persistence.*;
import java.util.Set;


public class Category {


    private Long id;

    private String name;

//    user that this category belongs to. Only categories you make should you be able to use.
    private User user;

    private Set<Plushie> plushies;

    public Category(){} //blank constructor

    public Category(Long id, String name, User user, Set<Plushie> plushies) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.plushies = plushies;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Plushie> getPlushies() {
        return plushies;
    }

    public void setPlushies(Set<Plushie> plushies) {
        this.plushies = plushies;
    }

}
