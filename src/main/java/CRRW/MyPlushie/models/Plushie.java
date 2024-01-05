package CRRW.MyPlushie.models;

import javax.persistence.*;
import java.util.Set;

@ Entity
public class Plushie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Emblem emblem;
    private byte[] photo; // we can store the binary data of the image, making it easier to store in MySQL.
    private Integer zipcode;

    private User user;
    private String purchaseLink;

    @OneToMany(mappedBy = "plushie_id")

    private Set<Category> categories;
    //private Category categories;

   // No Arg constructor for the JPA to create new instance

    public Plushie() {}


    // TODO: finish constructor and get/set stuff
    // TODO: include categories

    public Plushie(Long id, String name, Emblem emblem, byte[] photo, Integer zipcode, User user, String purchaseLink,Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.photo = photo;
        this.zipcode = zipcode;
        this.user = user;
        this.purchaseLink = purchaseLink;
        this.categories = categories;
    }

    public Long getId () {
        return id;
    }

     /* public void setId(Long id) {
    //  this.id = id;
     } */

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


   public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
