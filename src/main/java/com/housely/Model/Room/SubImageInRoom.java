package com.housely.Model.Room;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.housely.Model.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class SubImageInRoom {
    @Id
    private String subImageId;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String subImageBase64;


//    // Relationship with Room
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "roomId", nullable = false)
//    private Room room;
//
//    // Relationship with Product
//    @ManyToMany
//    @JoinTable(
//            name = "productInSubImage",
//            joinColumns = @JoinColumn(name = "subImageId"),
//            inverseJoinColumns = @JoinColumn(name = "productCode"))
//    private List<Product> productsInSubImage;


}
