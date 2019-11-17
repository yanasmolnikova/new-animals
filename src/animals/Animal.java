package animals;

import java.io.Serializable;

public abstract class Animal implements Comparable<Animal>, Serializable {

     private int id;
     private String name;
     private int foodAmount;
     private int weight;

     public Animal(int id, String name, int foodAmount, int weight){
         this.id = id;
         this.name = name;
         this.foodAmount = foodAmount;
         this.weight = weight;
     }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFoodAmount(){
         return foodAmount;
    }

    public abstract int calculateFoodAmount();

    public int compareTo(Animal other) {
        int order = other.calculateFoodAmount() - this.calculateFoodAmount();
        if (order == 0){
            return this.name.compareTo(other.name);
        }
        return order; // сортировка по убыванию количества еды
    }

    @Override
    public String toString() {
        return "Animal [id=" + this.getId() + ", name=" + this.getName() + ", foodAmount=" + this.getFoodAmount() + ", weight=" + this.getWeight() + "]";
    }
 }
