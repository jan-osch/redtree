package pl.edu.uj.jg.catalogue.domain.social;

import javax.persistence.Entity;

@Entity
public class Review extends Rating {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
