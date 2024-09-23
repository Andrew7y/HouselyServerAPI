package com.housely.Model.Review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
//    @Column(nullable = false)
    private double rating;
    private String comment;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReview;


    // Relationship with Customer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reviews")
    private Customer customer;

    // Relationship with Product
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productCode")
    @JsonIgnoreProperties("reviews")
    private Product product;

}
