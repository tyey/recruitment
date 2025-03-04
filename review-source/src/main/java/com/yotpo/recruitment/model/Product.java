package com.yotpo.recruitment.model;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private BigDecimal price;

    @OneToMany(mappedBy="product")
    private Set<Review> reviews;
}
