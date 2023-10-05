/*
 * Класс Nursery прозводит учёт животных
 */

package Programm;

import java.util.ArrayList;

import Programm.Animals.Animal;

public class Nursery {
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void showAnimals(){
        StringBuilder text = new StringBuilder("Список животных:\n");
        text.append("#| Группа\t|Вид\t|Кличка\t|Дата рождения\n");
        for (int i = 0; i < animals.size(); i++) {
            text.append(i + "| "+ animals.get(i).toString() + "\n");
        }
        System.out.println(text.toString());
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }


}
