package CRRW.MyPlushie.repositories;

import CRRW.MyPlushie.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsernameIgnoreCase(String username);
    User findByUsername(String username);


}
