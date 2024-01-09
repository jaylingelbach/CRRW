package repository;// PlushieRepository.java (Repository)
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlushieRepository extends JpaRepository<Plushie, Long> {
    // You can add custom query methods here if needed
}