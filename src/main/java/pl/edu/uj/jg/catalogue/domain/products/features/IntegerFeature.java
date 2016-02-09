package pl.edu.uj.jg.catalogue.domain.products.features;

import pl.edu.uj.jg.catalogue.domain.products.attributes.IntegerAttribute;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IntegerFeature extends AbstractFeature {

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private IntegerAttribute attribute;

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public IntegerAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(IntegerAttribute attribute) {
        this.attribute = attribute;
    }
}
