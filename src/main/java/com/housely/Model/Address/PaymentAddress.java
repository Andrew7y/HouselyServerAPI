package com.housely.Model.Address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Order.CustomerOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentAddressId;

    private String firstName;

    private String lastName;

    private String country;

    private String province;

    private String district;

    private String subDistrict;

    private String houseNumber;
    private String streetAlleyVillage;

    private String zipCode;

    private String phoneNumber;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fkToOrderId", referencedColumnName = "orderId")
    @JsonIgnoreProperties("paymentAddress")
    private CustomerOrder customerOrder;

    @OneToOne
    @JoinColumn(name = "fkToCusId", referencedColumnName = "id")
    @JsonIgnoreProperties("paymentAddress")
    private Customer customer;

}
