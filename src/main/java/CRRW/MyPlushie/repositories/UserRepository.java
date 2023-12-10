package CRRW.MyPlushie.repositories;

import CRRW.MyPlushie.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
