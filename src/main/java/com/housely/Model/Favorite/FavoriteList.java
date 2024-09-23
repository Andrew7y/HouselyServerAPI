package com.housely.Model.Favorite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteListId;
    private String favoriteListName;


    // Relationship with Customer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("favorites")
    private Customer customer;

    // Relationship with Product
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "favoriteListItem",
            joinColumns = @JoinColumn(name = "favoriteListId"),
            inverseJoinColumns = @JoinColumn(name = "productCode"))
    @JsonIgnoreProperties("favoriteLists")
    private List<Product> productInFavoriteList;
}
