package pl.edu.uj.jg.catalogue.domain.social;

import pl.edu.uj.jg.catalogue.domain.base.NamedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Account extends NamedEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<Rating> ratings;

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }
}
