package cat.itacademy.s04.t02.n01.controllers;


import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")


public class FruitController {

    private final FruitService fruitService;


    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }

    @PostMapping
    public Fruit addFruit(@RequestBody Fruit fruit) {
        return fruitService.addFruit(fruit);

    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable int id) {
        return fruitService.getFruitById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFruitById(@PathVariable int id) {
        fruitService.deleteFruitById(id);
    }


}
