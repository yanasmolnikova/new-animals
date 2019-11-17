package animals;

public class Omnivorous extends Animal {    //всеядные
    public Omnivorous(int id, String name, int foodAmount, int weight) {
        super(id, name, foodAmount, weight);
    }

    public int calculateFoodAmount(){

        return getWeight() +  getFoodAmount();
    }
}
