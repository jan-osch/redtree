package pl.edu.uj.jg.domain.base;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DatedEntity extends BaseEntity {
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private DateTime dateCreated;

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DatedEntity() {
    }

    public DatedEntity(String name) {
        this.setNow();
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setNow() {
        this.dateCreated = new DateTime();
    }
}
