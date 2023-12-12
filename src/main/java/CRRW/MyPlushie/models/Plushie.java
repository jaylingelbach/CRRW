package CRRW.MyPlushie.models;

import java.util.Set;


public class Plushie {


    private Long id;

    private String name;
    private Emblem emblem;


    private User user;

    private Set<Category> categories;

//    blank constructor
    public Plushie(){}

    public Plushie(Long id, String name, Emblem emblem, User user, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.user = user;
        this.categories = categories;
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

    public Emblem getEmblem() {
        return emblem;
    }

    public void setEmblem(Emblem emblem) {
        this.emblem = emblem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
