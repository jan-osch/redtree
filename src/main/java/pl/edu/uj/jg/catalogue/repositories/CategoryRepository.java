package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.products.Category;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
