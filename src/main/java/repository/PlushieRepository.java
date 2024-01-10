package repository;// PlushieRepository.java (Repository)
import CRRW.MyPlushie.models.Plushie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlushieRepository extends CrudRepository<Plushie, Long> {
    // You can add custom query methods here if needed
}