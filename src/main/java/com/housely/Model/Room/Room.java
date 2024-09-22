package com.housely.Model.Room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String imageBase64;
    @Column(nullable = false)
    private String roomName;


    // Relationship with Product
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "productRoom",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "productCode"))
    @JsonIgnoreProperties("rooms")
    private List<Product> productInRooms;

//    // Relationship with SubImageInRoom
//    @JsonManagedReference
//    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<SubImageInRoom> subImageInRooms;

}
