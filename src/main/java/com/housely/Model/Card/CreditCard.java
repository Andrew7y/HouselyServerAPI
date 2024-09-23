package com.housely.Model.Card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Order.CustomerOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CreditCard {
    @Id
    private String creditCardNumber;

    @Column(nullable = false)
    private String yearExp;

    @Column(nullable = false)
    private String monthExp;

    @Column(nullable = false)
    private String CVV;

    @JsonIgnoreProperties("creditCards")
    @ManyToMany(mappedBy = "creditCards", fetch = FetchType.EAGER)
    private List<Customer> customers;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("creditCard")
    private List<CustomerOrder> customerOrders;

}
