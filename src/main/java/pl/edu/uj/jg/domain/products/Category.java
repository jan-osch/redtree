package pl.edu.uj.jg.domain.products;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Category extends AbstractCategory {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
    Collection<AbstractCategory> subcategories;

    public Collection<AbstractCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<AbstractCategory> subcategories) {
        this.subcategories = subcategories;
    }


    public void addSubcategory(AbstractCategory subcategory) {
        this.getSubcategoriesInternal().add(subcategory);
    }

    public void removeSubcategory(AbstractCategory subcategory) {
        this.getSubcategoriesInternal().remove(subcategory);
    }

    public Collection<AbstractCategory> getSubcategoriesInternal() {
        if (this.subcategories == null) {
            this.subcategories = new HashSet<AbstractCategory>();
        }
        return this.subcategories;
    }
}
