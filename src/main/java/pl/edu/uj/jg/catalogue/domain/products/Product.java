package pl.edu.uj.jg.catalogue.domain.products;

import pl.edu.uj.jg.catalogue.domain.base.RatableEntity;
import pl.edu.uj.jg.catalogue.domain.products.features.AbstractFeature;
import pl.edu.uj.jg.catalogue.domain.social.Rating;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product extends RatableEntity {

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<AbstractFeature> features;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ratingSubject")
    private Collection<Rating> ratings;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryId")
    private LeafCategory category;

    public Product() {
    }

    public Collection<AbstractFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<AbstractFeature> features) {
        this.features = features;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LeafCategory getCategory() {
        return category;
    }

    public void setCategory(LeafCategory category) {
        this.category = category;
    }
}
