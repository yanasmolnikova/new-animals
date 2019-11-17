package animals;

public class Predator extends Animal{   //хищники
    public Predator(int id, String name, int foodAmount, int weight) {
        super(id, name, foodAmount, weight);
    }
    public int calculateFoodAmount(){

        return getFoodAmount() * getWeight();
    }
}