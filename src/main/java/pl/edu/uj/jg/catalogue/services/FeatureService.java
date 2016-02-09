package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.products.features.BooleanFeature;
import pl.edu.uj.jg.catalogue.domain.products.features.IntegerFeature;
import pl.edu.uj.jg.catalogue.domain.products.features.StringFeature;

import java.util.Collection;

public interface FeatureService {
    StringFeature addStringFeature(Long productId, String value, Long attributeId);

    Collection<StringFeature> getAllStringFeaturesForProduct(Long productId);

    void deleteStringFeature(Long featureId);

    BooleanFeature addBooleanFeature(Long productId, Boolean value, Long attributeId);

    Collection<BooleanFeature> getAllBooleanFeaturesForProduct(Long productId);

    void deleteBooleanFeature(Long featureId);

    IntegerFeature addIntegerFeature(Long productId, Integer value, Long attributeId);

    Collection<IntegerFeature> getAllIntegerFeaturesForProduct(Long productId);

    void deleteIntegerFeature(Long featureId);
}
