package model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Establishing a Many-to-One relationship: Many categories can belong to one user account
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    // Establishing a Many-to-Many relationship: Each category can be associated with multiple plushies
    @ManyToMany(mappedBy = "categories")
    private Set<Plushie> plushies;

    // Constructors, getters, setters...
}
