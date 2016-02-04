package pl.edu.uj.jg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.domain.social.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
}
