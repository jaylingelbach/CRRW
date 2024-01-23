package CRRW.MyPlushie.repositories;

import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlushieRepository extends CrudRepository<Plushie,Long> {
    List<Plushie> findAll();
    List<Plushie> findAllByOrderByName();
    List<Plushie> findAllByOrderByDateAdopted();
    List<Plushie> findAllByOrderByEmblem();

}
