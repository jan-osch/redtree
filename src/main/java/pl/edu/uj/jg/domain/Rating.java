package pl.edu.uj.jg.domain;

import pl.edu.uj.jg.domain.base.DatedEntity;
import pl.edu.uj.jg.domain.base.RateableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating extends DatedEntity {
    private float rate;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private RateableEntity subject;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Rating(float rate, RateableEntity subject, Account account) {
        this.rate = rate;
        this.subject = subject;
        this.account = account;
    }

    public Rating() {
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public RateableEntity getSubject() {
        return subject;
    }

    public void setSubject(RateableEntity subject) {
        this.subject = subject;
    }
}
