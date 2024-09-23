package com.housely.Model.Cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @EmbeddedId
    private CartItemKey id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productCode")
    @JoinColumn(name = "product_code")
    @JsonIgnoreProperties("cartItems")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    @JsonIgnoreProperties("cartItems")
    private Cart cart;

    private Long quantity;


}
