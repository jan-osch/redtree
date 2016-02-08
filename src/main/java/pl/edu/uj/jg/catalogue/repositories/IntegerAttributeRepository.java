package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.IntegerAttribute;

@Repository
public interface IntegerAttributeRepository extends GenericAttributeRepository<IntegerAttribute>{
}
