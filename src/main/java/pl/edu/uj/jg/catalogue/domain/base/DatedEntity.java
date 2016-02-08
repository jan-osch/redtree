package pl.edu.uj.jg.catalogue.domain.base;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DatedEntity extends BaseEntity {
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateCreated;

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DatedEntity() {
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setNow() {
        this.dateCreated = new DateTime();
    }
}
