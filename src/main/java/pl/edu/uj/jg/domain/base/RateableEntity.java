package pl.edu.uj.jg.domain.base;

import javax.persistence.Entity;

@Entity
public abstract class RateableEntity extends NamedEntity{
    public RateableEntity(String name) {
        super(name);
    }

    public RateableEntity() {
    }
}
