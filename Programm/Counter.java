package Programm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Programm.Animals.Camel;
import Programm.Animals.Cat;
import Programm.Animals.Dog;
import Programm.Animals.Donkey;
import Programm.Animals.Hamster;
import Programm.Animals.Horse;

public class Counter {
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void add(Nursery nursery) throws AddExeption {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вид животного: ");
        String type = scanner.nextLine();
        System.out.println("Кличка животного: ");
        String name = scanner.nextLine();
        System.out.println("Дата рождения: ");
        String dateText = scanner.nextLine();
        LocalDate date;

        if (type.isEmpty() || name.isEmpty() || dateText.isEmpty()) {
            throw new AddExeption("Неполные данные!");
        }
        try {
            date = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new AddExeption("Неверный формат даты!");
        }

        switch (type.toLowerCase()) {
            case "cat":
            case "кот":
            case "кошка":
                nursery.addAnimal(new Cat(getCount(), name, date));
                break;
            case "dog":
            case "пёс":
            case "пес":
            case "собака":
                nursery.addAnimal(new Dog(getCount(), name, date));
                break;
            case "hamster":
            case "хомяк":
                nursery.addAnimal(new Hamster(getCount(), name, date));
                break;
            case "horse":
            case "лошадь":
            case "конь":
                nursery.addAnimal(new Horse(getCount(), name, date));
                break;
            case "camel":
            case "верблюд":
                nursery.addAnimal(new Camel(getCount(), name, date));
                break;
            case "donkey":
            case "осёл":
                nursery.addAnimal(new Donkey(getCount(), name, date));
                break;
            default:
                break;
        }
        count++;
    }
}

class AddExeption extends Exception {
    public AddExeption(String text) {
        super(text);
    }

}
