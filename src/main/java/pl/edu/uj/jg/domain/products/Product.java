package pl.edu.uj.jg.domain.products;

import pl.edu.uj.jg.domain.base.RatableEntity;
import pl.edu.uj.jg.domain.social.Rating;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Product extends RatableEntity {

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<AbstractFeature> features;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ratingSubject")
    private Collection<Rating> ratings;

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
