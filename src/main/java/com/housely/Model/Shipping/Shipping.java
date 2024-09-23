package com.housely.Model.Shipping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Address.ShippingAddress;
import com.housely.Model.Order.CustomerOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingId;

    private String targetFirstName;

    private String targetLastName;

    private String targetPhoneNumber;

    private String shippingStatus;

    private LocalDate shippingDate;

    private String shippingMethod;

    private String trackingNumber;


    // Relationship with CustomerOrder
    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    @JsonIgnoreProperties("shipping")
    private CustomerOrder customerOrder;

//    // Relationship with ShippingAddress
    @OneToOne(mappedBy = "shipping")
    @JsonIgnoreProperties("shipping")
    private ShippingAddress shippingAddress;
}
