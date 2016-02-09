package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.LeafCategory;

@Repository
public interface LeafCategoryRepository extends CrudRepository<LeafCategory, Long> {
    LeafCategory findByName(String name);
}
