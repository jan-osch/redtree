package pl.edu.uj.jg.domain.social;

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
