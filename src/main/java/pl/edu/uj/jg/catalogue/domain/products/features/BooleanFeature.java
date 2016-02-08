package pl.edu.uj.jg.catalogue.domain.products.features;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BooleanFeature extends AbstractFeature {

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private BooleanAttribute attribute;

    private Boolean value;

    public BooleanAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(BooleanAttribute attribute) {
        this.attribute = attribute;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
