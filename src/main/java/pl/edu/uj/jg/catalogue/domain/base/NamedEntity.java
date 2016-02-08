package pl.edu.uj.jg.catalogue.domain.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public NamedEntity() {
    }

    public NamedEntity(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
