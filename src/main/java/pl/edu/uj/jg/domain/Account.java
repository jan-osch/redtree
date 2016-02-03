package pl.edu.uj.jg.domain;

import pl.edu.uj.jg.domain.base.NamedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Account extends NamedEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Review> reviews;

    public Account(String name) {
        super(name);
    }

    public Account() {
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
