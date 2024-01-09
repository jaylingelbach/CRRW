package model;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plushie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Emblem emblem;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    // Establishing a Many-to-Many relationship: Each plushie can belong to multiple categories
//    @ManyToMany
//    @JoinTable(
//            name = "plushie_category",
//            joinColumns = @JoinColumn(name = "plushie_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private Set<Category> categories;

//    blank constructor
    public Plushie(){

    //public Plushie(Long id, String name, Emblem emblem, UserAccount userAccount, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.userAccount = userAccount;

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

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }



}
