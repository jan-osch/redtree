package pl.edu.uj.jg.catalogue.repositories.features;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.StringFeature;
import pl.edu.uj.jg.catalogue.repositories.features.GenericFeatureRepository;

@Repository
public interface StringFeatureRepository extends GenericFeatureRepository<StringFeature> {
}
