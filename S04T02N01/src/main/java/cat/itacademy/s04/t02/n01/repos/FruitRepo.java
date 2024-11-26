package cat.itacademy.s04.t02.n01.repos;

import cat.itacademy.s04.t02.n01.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepo extends JpaRepository<Fruit,Integer> {
}
