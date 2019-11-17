package animals;

import java.io.Serializable;

public class Herbivorous extends Animal {   //травоядные
    public Herbivorous(int id, String name, int foodAmount, int weight) {
        super(id, name, foodAmount, weight);
    }

    public int calculateFoodAmount(){

        return (getFoodAmount() + getWeight()) / 2;
    }
}


