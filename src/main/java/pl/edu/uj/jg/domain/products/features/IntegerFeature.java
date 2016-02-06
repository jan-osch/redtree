package pl.edu.uj.jg.domain.products.features;

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
