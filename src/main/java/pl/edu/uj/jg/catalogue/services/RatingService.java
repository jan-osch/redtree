package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.social.Rating;

public interface RatingService {
    Rating saveOrUpdateRating(Rating rating);
}
