package cat.itacademy.s04.t02.n01.services;


import cat.itacademy.s04.t02.n01.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repos.FruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepo fruitRepo;

    @Autowired
    public FruitService(FruitRepo fruitRepo) {
        this.fruitRepo = fruitRepo;
    }

    /*getAll*/

    public List<Fruit> getAllFruits() {
        return fruitRepo.findAll();
    }

    /*Add*/


    public Fruit addFruit(Fruit fruit) {


        return fruitRepo.save(fruit);

    }


    /*Update*/

    /*GetById{id}*/

    public Fruit getFruitById(int id) {
        return fruitRepo.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit with id "+ id + " doesn't exist."));

    }


    /*Delete{id}*/
    public void deleteFruitById(int id) {
        fruitRepo.deleteById(id);
    }


}


