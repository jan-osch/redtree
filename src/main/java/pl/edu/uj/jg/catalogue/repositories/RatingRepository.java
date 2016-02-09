package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.social.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
}
