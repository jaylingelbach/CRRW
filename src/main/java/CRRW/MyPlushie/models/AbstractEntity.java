package CRRW.MyPlushie.models;


import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private long id;


    //@NotBlank (message = "Please enter a name")
    //@Size(min=3, max= 200, message= "Name must be 3-200 characters long")
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}