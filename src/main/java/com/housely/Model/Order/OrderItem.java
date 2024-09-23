package com.housely.Model.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @EmbeddedId
    private OrderItemKey orderItemId;
    private int quantity;


    // Relationship with CustomerOrder
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("orderItems")
    private CustomerOrder customerOrder;

    // Relationship with Product
    @ManyToOne
    @MapsId("productCode")
    @JoinColumn(name = "product_code")
    @JsonIgnoreProperties("orderItems")
    private Product product;

}
