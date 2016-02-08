package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.BooleanFeature;

@Repository
public interface BooleanFeatureRepository extends GenericFeatureRepository<BooleanFeature> {
}
