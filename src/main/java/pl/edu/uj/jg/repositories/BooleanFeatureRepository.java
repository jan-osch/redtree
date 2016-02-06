package pl.edu.uj.jg.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.domain.products.features.BooleanFeature;

@Repository
public interface BooleanFeatureRepository extends GenericFeatureRepository<BooleanFeature> {
}
