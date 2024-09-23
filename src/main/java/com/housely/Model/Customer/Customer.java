package com.housely.Model.Customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Address.PaymentAddress;
import com.housely.Model.Address.ShippingAddress;
import com.housely.Model.Card.CreditCard;
import com.housely.Model.Cart.Cart;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Model.Order.CustomerOrder;
import com.housely.Model.Review.Review;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String email;

    private String password;


    // Relationship
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private List<Review> reviews;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private List<FavoriteList> favorites;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "customerCreditCard",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "creditCardNumber"))
    @JsonIgnoreProperties("customers")
    private List<CreditCard> creditCards;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private List<CustomerOrder> customerOrders;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private PaymentAddress paymentAddress;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private List<ShippingAddress> shippingAddresses;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private Cart cart;


}
