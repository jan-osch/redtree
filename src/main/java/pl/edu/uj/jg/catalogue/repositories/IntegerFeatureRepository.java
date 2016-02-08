package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.features.IntegerFeature;

@Repository
public interface IntegerFeatureRepository extends GenericFeatureRepository<IntegerFeature>{
}
