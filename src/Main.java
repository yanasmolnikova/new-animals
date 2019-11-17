import animals.Animal;
import animals.Herbivorous;
import animals.Omnivorous;
import animals.Predator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws java.io.IOException, ClassNotFoundException {
        Herbivorous dinosaur = new Herbivorous(1, "динозавр", 10, 230);
        Herbivorous cow = new Herbivorous(2, "корова", 90, 140);
        Omnivorous lion = new Omnivorous(3, "лев", 20, 100);
        Omnivorous hippo = new Omnivorous(4, "бегемот", 300, 300);
        Predator monkey = new Predator(5, "шимпанзе", 40, 50);
        Predator tiger = new Predator(6, "тигр", 50, 70);

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(dinosaur);
        animals.add(lion);
        animals.add(cow);
        animals.add(hippo);
        animals.add(monkey);
        animals.add(tiger);

        // пункт 4 и 5
        try
        {
            FileOutputStream fos = new FileOutputStream("data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animals);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        List<Animal> fileAnimals = new ArrayList<Animal>();

        try
        {
            FileInputStream fis = new FileInputStream("data");
            ObjectInputStream ois = new ObjectInputStream(fis);

            fileAnimals = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        for (Animal animal : fileAnimals) {
            System.out.println(animal.calculateFoodAmount());
        }

        Collections.sort(animals);

        System.out.println("пункт 1");

        for (Animal animal : animals)
            System.out.println("id: " + animal.getId() + ", " + animal.getName() + ", " +
                    "количество еды: " + animal.calculateFoodAmount() + ", класс: " + animal.getClass().getSimpleName());

        System.out.println("пункт 2");

        for (int i = 0; i < 5; i++) {
            System.out.println(animals.get(i).getName());
        }

        System.out.println("пункт 3");
        System.out.println(animals.size());

        for (int i = animals.size() - 3; i < animals.size(); i++) {
            System.out.println(animals.get(i).getId());
        }
    }

}

