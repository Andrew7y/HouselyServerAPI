package com.housely.Controller;

import com.housely.Model.Category.Category;
import com.housely.Model.Product.Product;
import com.housely.Model.Room.Room;
import com.housely.Service.CategoryService;
import com.housely.Service.ProductService;
import com.housely.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Create a new room
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room newRoom = roomService.save(room);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    // Get all rooms
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.findAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    // Get room by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {
        try {
            Room room = roomService.findById(id);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Update a room by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        try {
            updatedRoom.setId(id);
            Room room = roomService.save(updatedRoom);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Delete a room by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        try{
            roomService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
