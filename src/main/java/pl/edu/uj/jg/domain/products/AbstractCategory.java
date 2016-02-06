package pl.edu.uj.jg.domain.products;

import pl.edu.uj.jg.domain.base.NamedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class AbstractCategory extends NamedEntity{
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parentId")
    Category parent;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
