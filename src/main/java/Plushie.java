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
    private UserAccount userAccount;

    //    there seems to be multiple ways to get basic images working, will need to research this tho.
    // following text is just Pseudocode
//    private Image profileImage;

    public Plushie() {
        // Default constructor
    }

    public Plushie(String name, Emblem emblem, UserAccount userAccount) {
        this.name = name;
        this.emblem = emblem;
        this.userAccount = userAccount;
    }
}
