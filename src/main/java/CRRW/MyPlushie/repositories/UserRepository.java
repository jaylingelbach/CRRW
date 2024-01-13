package CRRW.MyPlushie.repositories;

import CRRW.MyPlushie.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsernameIgnoreCase(String username);
    Optional<User> findByUsername(String username);


}
