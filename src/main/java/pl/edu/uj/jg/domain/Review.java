package pl.edu.uj.jg.domain;

import pl.edu.uj.jg.domain.base.DatedEntity;
import pl.edu.uj.jg.domain.base.RateableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review extends DatedEntity{

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private RateableEntity subject;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private float rate;
    private String content;

    public Review() {
    }

    public RateableEntity getSubject() {
        return subject;
    }

    public void setSubject(RateableEntity subject) {
        this.subject = subject;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
