package pl.edu.uj.jg.domain;

import pl.edu.uj.jg.domain.base.RateableEntity;

import javax.persistence.Entity;

@Entity
public class Product extends RateableEntity {

    private String description;

    public Product(String name, String description) {
        super(name);
        this.description = description;
    }

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
