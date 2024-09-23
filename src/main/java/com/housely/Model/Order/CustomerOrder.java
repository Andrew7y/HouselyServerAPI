package com.housely.Model.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Card.CreditCard;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Address.PaymentAddress;
import com.housely.Model.Shipping.Shipping;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    private String paymentStatus;

    private double totalAmount;


    // Relationship with CreditCard
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creditCardNumber")
    @JsonIgnoreProperties("customerOrders")
    private CreditCard creditCard;

    // Relationship with Customer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("customerOrders")
    private Customer customer;

    // Relationship with OrderItem
    @JsonIgnoreProperties("customerOrder")
    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    // Relationship with PaymentAddress
    @OneToOne(mappedBy = "customerOrder", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customerOrder")
    private PaymentAddress paymentAddress;

//    // Relationship with Shipping
    @OneToOne(mappedBy = "customerOrder")
    @JsonIgnoreProperties("customerOrder")
    private Shipping shipping;

}
