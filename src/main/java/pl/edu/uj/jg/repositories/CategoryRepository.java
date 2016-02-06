package pl.edu.uj.jg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.domain.products.Category;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
