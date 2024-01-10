package CRRW.MyPlushie.models;

import java.util.List;
import java.sql.Date;
import javax.persistence.*;
@Entity
public class Plushie {

    private String name;
    private Emblem emblem;
    private String description;
    private Date dateAdopted;
    private String purchaseLink;

    // Constructors, getters, and setters
    //...



    @Id
    @GeneratedValue

    private Long id;

    private byte[] photo; // we can store the binary data of the image, making it easier to store in MySQL.
    private Integer zipcode;
    private User user;

    //blank constructor

    public Plushie() {
    }


    public Plushie(Long id, String name, Emblem emblem, String description, Date dateAdopted, byte[] photo, Integer zipcode, User user, String purchaseLink) {
        this.id = id;
        this.name = name;
        this.emblem = emblem;
        this.description = description;
        this.dateAdopted = dateAdopted;
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


    public void setName(String name) {
        this.name = name;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public void setEmblem(Emblem emblem) {
        this.emblem = emblem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdopted() {
        return dateAdopted;
    }

    public void setDateAdopted(Date dateAdopted) {
        this.dateAdopted = dateAdopted;
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