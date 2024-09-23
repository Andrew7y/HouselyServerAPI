package com.housely.Model.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.housely.Model.Cart.CartItem;
import com.housely.Model.Category.Category;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Model.Order.OrderItem;
import com.housely.Model.Review.Review;
import com.housely.Model.Room.Room;
import com.housely.Model.Room.SubImageInRoom;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String productCode ;
    private String brandName ;
    private String productName ;
    private String price;
    private String color;
    private String size;
    private int quantity;
//    @Lob
//    @Column(columnDefinition = "LONGTEXT")
//    private String imageBase64;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;


    // Relationship with Review
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("product")
    private List<Review> reviews;

    // Relationship with Room

    @ManyToMany(mappedBy = "productInRooms", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("productInRooms")
    private List<Room> rooms;

    // Relationship with Category
    @ManyToMany(mappedBy = "productInCategories")
    @JsonIgnoreProperties("productInCategories")
    private List<Category> categories;

    // Relationship with FavoriteList
    @ManyToMany(mappedBy = "productInFavoriteList", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("productInFavoriteList")
    private List<FavoriteList> favoriteLists;

    // Relationship with CartItem
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("product")
    private List<CartItem> cartItems;

    // Relationship with OrderItem
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("product")
    private List<OrderItem> orderItems;


}
