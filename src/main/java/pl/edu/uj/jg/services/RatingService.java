package pl.edu.uj.jg.services;

import pl.edu.uj.jg.domain.Rating;

public interface RatingService {
    Rating saveOrUpdateRating(Rating rating);
}
