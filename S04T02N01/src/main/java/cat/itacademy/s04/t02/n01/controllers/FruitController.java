package cat.itacademy.s04.t02.n01.controllers;


import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.services.FruitService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")


public class FruitController {


    @Autowired
    private final FruitService fruitService;


    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getAllFruits() {

        try {
            List<Fruit> fruites = fruitService.getAllFruits();
            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {


        try {
            Fruit newFruit = fruitService.addFruit(fruit);
            return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {
        try {
            Fruit fruit = fruitService.getFruitById(id);
            return new ResponseEntity<>(fruit, HttpStatus.OK);

        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById(@PathVariable int id) {


        try {
            fruitService.deleteFruitById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
