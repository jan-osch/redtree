package pl.edu.uj.jg.catalogue.domain.products;

import pl.edu.uj.jg.catalogue.domain.base.RatableEntity;
import pl.edu.uj.jg.catalogue.domain.products.features.AbstractFeature;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product extends RatableEntity {

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<AbstractFeature> features;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryId")
    private LeafCategory category;

    private String imageUrl;

    public Product() {
    }

    public Collection<AbstractFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<AbstractFeature> features) {
        this.features = features;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
