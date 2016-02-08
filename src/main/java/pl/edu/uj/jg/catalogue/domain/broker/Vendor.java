package pl.edu.uj.jg.catalogue.domain.broker;

import pl.edu.uj.jg.catalogue.domain.base.RatableEntity;
import pl.edu.uj.jg.catalogue.domain.social.Rating;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Vendor extends RatableEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ratingSubject")
    private Collection<Rating> ratings;

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }
}
