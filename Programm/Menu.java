package Programm;

import java.util.Scanner;

import Programm.Animals.Animal;

public class Menu {

    public boolean mainMenu(Nursery nursery) {
        System.out.println("1 - Показать список животных\n" +
                "2 - Добавить животное\n" +
                "3 - Показать список комманд животного\n" +
                "4 - Обучить животное\n" +
                "5 - Выход\n");
        System.out.println("Введите команду: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String request = scanner.nextLine();

            switch (request) {
                case "1":
                    showAnimals(nursery);
                    break;
                case "2":
                    addAnimal(nursery);
                    break;
                case "3":
                    showCommands(nursery);
                    break;
                case "4":
                    try {
                        addCommand(nursery);
                    } catch (AddExeption e) {
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    return false;
                default:
                    break;
            }
        }
        return true;
    }

    private void showAnimals(Nursery nursery) {
        nursery.showAnimals();
    }

    private void addAnimal(Nursery nursery) {
        try {
            Counter.add(nursery);
        } catch (AddExeption e) {
            e.printStackTrace();
        }
    }

    private void showCommands(Nursery nursery) {
        nursery.showAnimals();
        System.out.println("Введите номер животного: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            for (Animal animal : nursery.getAnimals()) {
                if (animal.getId() == number) {
                    System.out.println(animal.showCommands());
                }            
            }
        }
    }

    private void addCommand(Nursery nursery) throws AddExeption {
        nursery.showAnimals();
        System.out.println("Введите номер животного: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            Animal animal = null;
            for (Animal item : nursery.getAnimals()) {
                if (item.getId() == number) {
                    animal = item;
                    break;
                }            
            }
            if(animal == null){
                throw new AddExeption("Неверный индекс!");
            }
            System.out.println("Введите команду: ");
            try (Scanner scanner2 = new Scanner(System.in)) {
                String command = scanner2.nextLine();
                animal.addCommand(command);
            }
        }

    }
}
