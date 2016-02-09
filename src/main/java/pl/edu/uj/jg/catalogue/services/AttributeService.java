package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.products.attributes.BooleanAttribute;
import pl.edu.uj.jg.catalogue.domain.products.attributes.IntegerAttribute;
import pl.edu.uj.jg.catalogue.domain.products.attributes.StringAttribute;

import java.util.Collection;

public interface AttributeService {
    StringAttribute createStringAttribute(String name);

    Collection<StringAttribute> getAllStringAttributes();

    StringAttribute getStringAttributeByName(String name);

    void deleteStringAttribute(Long id);

    BooleanAttribute createBooleanAttribute(String name);

    BooleanAttribute getBooleanAttributeByName(String name);

    Collection<BooleanAttribute> getAllBooleanAttributes();

    void deleteBooleanAttribute(Long id);

    IntegerAttribute createNumberAttribute(String name);

    IntegerAttribute getIntegerAttributeByName(String name);

    Collection<IntegerAttribute> getAllIntegerAttributes();

    void deleteIntegerAttribute(Long id);


}
