package CRRW.MyPlushie.repositories;// PlushieRepository.java (Repository)
import CRRW.MyPlushie.models.Plushie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlushieRepository extends CrudRepository<Plushie, Long> {
    // You can add custom query methods here if needed

    // these normally come with the CrudRepository but for some reason these methods had to be added manually
    List<Plushie> findAll();
    List<Plushie> findAllByOrderByName();
    List<Plushie> findAllByOrderByDateAdopted();
    List<Plushie> findAllByOrderByEmblem();
}