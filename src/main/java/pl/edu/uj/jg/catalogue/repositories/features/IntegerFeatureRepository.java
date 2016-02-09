package pl.edu.uj.jg.catalogue.repositories.features;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.IntegerFeature;
import pl.edu.uj.jg.catalogue.repositories.features.GenericFeatureRepository;

@Repository
public interface IntegerFeatureRepository extends GenericFeatureRepository<IntegerFeature> {
}
