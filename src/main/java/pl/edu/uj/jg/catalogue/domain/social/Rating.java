package pl.edu.uj.jg.catalogue.domain.social;

import pl.edu.uj.jg.catalogue.domain.base.DatedEntity;
import pl.edu.uj.jg.catalogue.domain.base.RatableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating extends DatedEntity {

    @ManyToOne(cascade= CascadeType.PERSIST)
    private RatableEntity ratingSubject;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "account_id")
    private Account account;

    private float rate;


    public RatableEntity getRatingSubject() {
        return ratingSubject;
    }

    public void setRatingSubject(RatableEntity ratingSubject) {
        this.ratingSubject = ratingSubject;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}

