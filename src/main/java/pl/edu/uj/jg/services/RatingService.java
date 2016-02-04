package pl.edu.uj.jg.services;

import pl.edu.uj.jg.domain.social.Rating;

public interface RatingService {
    Rating saveOrUpdateRating(Rating rating);
}
