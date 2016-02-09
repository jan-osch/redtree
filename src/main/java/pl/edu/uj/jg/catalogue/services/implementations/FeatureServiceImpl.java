package pl.edu.uj.jg.catalogue.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.products.attributes.BooleanAttribute;
import pl.edu.uj.jg.catalogue.domain.products.attributes.StringAttribute;
import pl.edu.uj.jg.catalogue.domain.products.features.*;
import pl.edu.uj.jg.catalogue.repositories.*;
import pl.edu.uj.jg.catalogue.repositories.attributes.BooleanAttributeRepository;
import pl.edu.uj.jg.catalogue.repositories.attributes.IntegerAttributeRepository;
import pl.edu.uj.jg.catalogue.repositories.attributes.StringAttributeRepository;
import pl.edu.uj.jg.catalogue.repositories.features.BooleanFeatureRepository;
import pl.edu.uj.jg.catalogue.repositories.features.IntegerFeatureRepository;
import pl.edu.uj.jg.catalogue.repositories.features.StringFeatureRepository;
import pl.edu.uj.jg.catalogue.services.FeatureService;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

    private BooleanFeatureRepository booleanFeatureRepository;
    private StringFeatureRepository stringFeatureRepository;
    private IntegerFeatureRepository integerFeatureRepository;
    private BooleanAttributeRepository booleanAttributeRepository;
    private StringAttributeRepository stringAttributeRepository;
    private IntegerAttributeRepository integerAttributeRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setBooleanAttributeRepository(BooleanAttributeRepository booleanAttributeRepository) {
        this.booleanAttributeRepository = booleanAttributeRepository;
    }

    @Autowired
    public void setStringAttributeRepository(StringAttributeRepository stringAttributeRepository) {
        this.stringAttributeRepository = stringAttributeRepository;
    }

    @Autowired
    public void setIntegerAttributeRepository(IntegerAttributeRepository integerAttributeRepository) {
        this.integerAttributeRepository = integerAttributeRepository;
    }

    @Autowired
    public void setBooleanFeatureRepository(BooleanFeatureRepository booleanFeatureRepository) {
        this.booleanFeatureRepository = booleanFeatureRepository;
    }

    @Autowired
    public void setStringFeatureRepository(StringFeatureRepository stringFeatureRepository) {
        this.stringFeatureRepository = stringFeatureRepository;
    }

    @Autowired
    public void setIntegerFeatureRepository(IntegerFeatureRepository integerFeatureRepository) {
        this.integerFeatureRepository = integerFeatureRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public StringFeature addStringFeature(Long productId, String value, Long attributeId) {
        StringAttribute stringAttribute = stringAttributeRepository.findOne(attributeId);
        StringFeature stringFeature = new StringFeature();
        stringFeature.setValue(value);
        stringFeature.setAttribute(stringAttribute);
        stringFeature.setProduct(productRepository.findOne(productId));
        return stringFeatureRepository.save(stringFeature);
    }

    @Override
    public List<StringFeature> getAllStringFeaturesForProduct(Long productId) {
        return stringFeatureRepository.findByProductId(productId);
    }

    @Override
    public void deleteStringFeature(Long featureId) {
        stringFeatureRepository.delete(featureId);
    }

    @Override
    public BooleanFeature addBooleanFeature(Long productId, Boolean value, Long attributeId) {
        BooleanAttribute booleanAttribute = booleanAttributeRepository.findOne(attributeId);
        BooleanFeature stringFeature = new BooleanFeature();
        stringFeature.setValue(value);
        stringFeature.setAttribute(booleanAttribute);
        stringFeature.setProduct(productRepository.findOne(productId));
        return booleanFeatureRepository.save(stringFeature);
    }

    @Override
    public Collection<BooleanFeature> getAllBooleanFeaturesForProduct(Long productId) {
        return booleanFeatureRepository.findByProductId(productId);
    }

    @Override
    public void deleteBooleanFeature(Long featureId) {
        booleanFeatureRepository.delete(featureId);
    }

    @Override
    public IntegerFeature addIntegerFeature(Long productId, Integer value, Long attributeId) {
        IntegerFeature feature = new IntegerFeature();
        feature.setValue(value);
        feature.setProduct(productRepository.findOne(productId));
        feature.setAttribute(integerAttributeRepository.findOne(attributeId));
        return integerFeatureRepository.save(feature);
    }

    @Override
    public Collection<IntegerFeature> getAllIntegerFeaturesForProduct(Long productId) {
        return integerFeatureRepository.findByProductId(productId);
    }

    @Override
    public void deleteIntegerFeature(Long featureId) {
        integerAttributeRepository.delete(featureId);
    }
}