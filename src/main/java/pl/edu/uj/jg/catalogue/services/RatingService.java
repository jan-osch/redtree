package pl.edu.uj.jg.catalogue.services;

public interface RatingService {
    void addRatingToProduct(Long productId, Float rating, Long accountId);
    void addReviewToProduct(Long productId, Float rating, String description, Long accountId);
    void removeRatingFromProduct(Long ratingId);
    void removeReviewFromProduct(Long reviewId);
}
