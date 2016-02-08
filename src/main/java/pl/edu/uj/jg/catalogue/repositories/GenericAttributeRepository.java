package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.edu.uj.jg.catalogue.domain.products.features.AbstractAttribute;

@NoRepositoryBean
public interface GenericAttributeRepository<T extends AbstractAttribute> extends CrudRepository<T, Long> {
    T findByName(String name);
}
