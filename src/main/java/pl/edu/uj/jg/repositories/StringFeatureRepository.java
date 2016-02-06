package pl.edu.uj.jg.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.domain.products.features.StringFeature;

@Repository
public interface StringFeatureRepository extends GenericFeatureRepository<StringFeature> {
}
