package com.yotpo.recruitment;

import com.yotpo.recruitment.model.Product;
import com.yotpo.recruitment.model.Review;
import com.yotpo.recruitment.model.Stars;
import com.yotpo.recruitment.repositories.ProductRepository;
import com.yotpo.recruitment.repositories.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
@Disabled
class RecruitmentApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldLoadProductWithReviews() {
        Optional<Product> product = productRepository.findById(1L);
        Assertions.assertTrue(product.isPresent());
        Set<Review> reviews = product.get().getReviews();
        Assertions.assertNotNull(reviews);
        Assertions.assertEquals(5, reviews.size());
    }

    @Test
    @Transactional
    void shouldAddReview(){
        Optional<Product> product = productRepository.findById(1L);
        Review review = new Review();
        review.setContent("test");
        review.setStars(Stars.FOUR);
        review.setProduct(product.get());

        Review saved = reviewRepository.save(review);

        Assertions.assertNotNull(saved.getId());
    }

}
