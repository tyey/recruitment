package com.yotpo.recruitment;

import com.yotpo.recruitment.model.Product;
import com.yotpo.recruitment.model.Review;
import com.yotpo.recruitment.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class RecruitmentApplicationTests {

    @Autowired
    private ProductRepository productRepository;

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

}
