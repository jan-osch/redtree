package pl.edu.uj.jg.catalogue.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.products.attributes.BooleanAttribute;
import pl.edu.uj.jg.catalogue.domain.products.attributes.IntegerAttribute;
import pl.edu.uj.jg.catalogue.domain.products.attributes.StringAttribute;
import pl.edu.uj.jg.catalogue.repositories.attributes.BooleanAttributeRepository;
import pl.edu.uj.jg.catalogue.repositories.attributes.IntegerAttributeRepository;
import pl.edu.uj.jg.catalogue.repositories.attributes.StringAttributeRepository;
import pl.edu.uj.jg.catalogue.services.AttributeService;

import java.util.Collection;

@Service
@Transactional
public class AttributeServiceImpl implements AttributeService {
    private IntegerAttributeRepository integerAttributeRepository;
    private BooleanAttributeRepository booleanAttributeRepository;
    private StringAttributeRepository stringAttributeRepository;

    @Autowired
    public void setIntegerAttributeRepository(IntegerAttributeRepository integerAttributeRepository) {
        this.integerAttributeRepository = integerAttributeRepository;
    }

    @Autowired
    public void setBooleanAttributeRepository(BooleanAttributeRepository booleanAttributeRepository) {
        this.booleanAttributeRepository = booleanAttributeRepository;
    }

    @Autowired
    public void setStringAttributeRepository(StringAttributeRepository stringAttributeRepository) {
        this.stringAttributeRepository = stringAttributeRepository;
    }

    @Override
    public StringAttribute createStringAttribute(String name) {
        StringAttribute stringAttribute = new StringAttribute();
        stringAttribute.setName(name);
        return stringAttributeRepository.save(stringAttribute);

    }

    @Override
    public Collection<StringAttribute> getAllStringAttributes() {
        return (Collection<StringAttribute>) stringAttributeRepository.findAll();
    }

    @Override
    public StringAttribute getStringAttributeByName(String name) {
        return stringAttributeRepository.findByName(name);
    }

    @Override
    public void deleteStringAttribute(Long id) {
        stringAttributeRepository.delete(id);
    }

    @Override
    public BooleanAttribute createBooleanAttribute(String name) {
        BooleanAttribute booleanAttribute = new BooleanAttribute();
        booleanAttribute.setName(name);
        return booleanAttributeRepository.save(booleanAttribute);
    }

    @Override
    public BooleanAttribute getBooleanAttributeByName(String name) {
        return booleanAttributeRepository.findByName(name);
    }

    @Override
    public Collection<BooleanAttribute> getAllBooleanAttributes() {
        return (Collection<BooleanAttribute>) booleanAttributeRepository.findAll();
    }

    @Override
    public void deleteBooleanAttribute(Long id) {
        booleanAttributeRepository.delete(id);
    }

    @Override
    public IntegerAttribute createNumberAttribute(String name) {
        IntegerAttribute integerAttribute = new IntegerAttribute();
        integerAttribute.setName(name);
        return integerAttributeRepository.save(integerAttribute);
    }

    @Override
    public IntegerAttribute getIntegerAttributeByName(String name) {
        return integerAttributeRepository.findByName(name);
    }

    @Override
    public Collection<IntegerAttribute> getAllIntegerAttributes() {
        return (Collection<IntegerAttribute>) integerAttributeRepository.findAll();
    }

    @Override
    public void deleteIntegerAttribute(Long id) {
        integerAttributeRepository.delete(id);
    }
}
