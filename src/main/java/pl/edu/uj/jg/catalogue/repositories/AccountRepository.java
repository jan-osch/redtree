package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.social.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

}
