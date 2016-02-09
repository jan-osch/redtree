package pl.edu.uj.jg.catalogue.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.social.Rating;
import pl.edu.uj.jg.catalogue.domain.social.Review;
import pl.edu.uj.jg.catalogue.repositories.AccountRepository;
import pl.edu.uj.jg.catalogue.repositories.ProductRepository;
import pl.edu.uj.jg.catalogue.repositories.RatingRepository;
import pl.edu.uj.jg.catalogue.repositories.ReviewRepository;
import pl.edu.uj.jg.catalogue.services.RatingService;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    private ReviewRepository reviewRepository;

    private AccountRepository accountRepository;

    private ProductRepository productRepository;

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addRatingToProduct(Long productId, Float rating, Long accountId) {
        Rating rate = new Rating();
        rate.setAccount(accountRepository.findOne(accountId));
        rate.setRatingSubject(productRepository.findOne(productId));
        rate.setRate(rating);
        ratingRepository.save(rate);
    }

    @Override
    public void addReviewToProduct(Long productId, Float rating, String description, Long accountId) {
        Review review = new Review();
        review.setAccount(accountRepository.findOne(accountId));
        review.setRatingSubject(productRepository.findOne(productId));
        review.setRate(rating);
        review.setContent(description);
        reviewRepository.save(review);
    }

    @Override
    public void removeRatingFromProduct(Long ratingId) {
        ratingRepository.delete(ratingId);
    }

    @Override
    public void removeReviewFromProduct(Long reviewId) {
        reviewRepository.delete(reviewId);
    }
}
