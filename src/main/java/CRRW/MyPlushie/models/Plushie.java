package CRRW.MyPlushie.models;

import java.util.List;
import javax.persistence.*;
public class Plushie {

    private String name;
    private String emblem;
    private String dateAdopted;
    private String purchaseLink;
    // Constructors, getters, and setters
    //...


//    @Entity
//    @Id
//    @GeneratedValue

    private Long id;

    private byte[] photo; // we can store the binary data of the image, making it easier to store in MySQL.
    private Integer zipcode;
    private User user;

    //private Set<Category> categories;

    //blank constructor

    public Plushie() {
    }


    //TODO:
    //finish contructor
    //and get/
    //set stuff

    public Plushie(Long id, String name, Emblem emblem, byte[] photo, Integer zipcode, User user, String purchaseLink) {
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.photo = photo;
        this.zipcode = zipcode;
        this.user = user;
        this.purchaseLink = purchaseLink;

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

    public void ListName(String name) {
        this.name = name;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public void ListEmblem(Emblem emblem) {
        this.emblem = emblem;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPurchaseLink() {
        return purchaseLink;
    }

    public void setPurchaseLink(String purchaseLink) {
        this.purchaseLink = purchaseLink;
    }

}