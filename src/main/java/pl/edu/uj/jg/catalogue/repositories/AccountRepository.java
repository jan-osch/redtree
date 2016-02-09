package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.uj.jg.catalogue.domain.social.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
}
