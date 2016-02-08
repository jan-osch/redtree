package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.StringAttribute;

@Repository
public interface StringAttributeRepository extends GenericAttributeRepository<StringAttribute>{
}
