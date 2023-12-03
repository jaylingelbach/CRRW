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

    public Plushie() {
        // Default constructor
    }

    public Plushie(String name, Emblem emblem) {
        this.name = name;
        this.emblem = emblem;
    }
}
