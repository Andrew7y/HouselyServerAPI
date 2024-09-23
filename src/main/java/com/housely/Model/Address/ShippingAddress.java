package com.housely.Model.Address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Shipping.Shipping;
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
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingAddressId;

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


    // Relationship
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("shippingAddresses")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "shippingIdFK", referencedColumnName = "shippingId")
    @JsonIgnoreProperties("shippingAddress")
    private Shipping shipping;

}
