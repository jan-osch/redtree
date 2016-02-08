package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.StringFeature;

@Repository
public interface StringFeatureRepository extends GenericFeatureRepository<StringFeature> {
}
