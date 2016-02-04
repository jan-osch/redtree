package pl.edu.uj.jg.domain.products;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StringFeature extends AbstractFeature {

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private StringAttribute attribute;

    private String value;

    public StringAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(StringAttribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
