package com.example.tourist.Controller;

import com.example.tourist.Model.Tourist;
import com.example.tourist.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "https://tourist-ui.herokuapp.com/", "https://tourist-user-interface.netlify.app/"})
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping("/all-tourists")
    public ResponseEntity<List<Tourist>> getAllTourists() {
        System.out.println("Rest request to get all Tourists");
        List<Tourist> temp = touristService.getAllTourists();
//        System.out.println("temp.toString() = " + temp.toString());
        return ResponseEntity.ok().body(temp);
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        System.out.println("Rest request to greet");
//        System.out.println("temp.toString() = " + temp.toString());
        return ResponseEntity.ok().body("Welcome to spring boot via docker");
    }

    @PostMapping("/add-tourist")
    public ResponseEntity<Tourist> addTourist(@RequestBody Tourist tourist) {
        System.out.println("Rest request to save Tourist : " + tourist.toString());
        return ResponseEntity.ok().body(touristService.addTourist(tourist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tourist> deleteTourist(@PathVariable String id) {
        System.out.println("Rest request to delete Tourist for id: " + id);
        touristService.deleteTourist(Integer.parseInt(id));
        return ResponseEntity.noContent().build();
    }
}
