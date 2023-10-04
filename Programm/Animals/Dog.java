package Programm.Animals;

import java.time.LocalDate;

public class Dog extends Pet {

    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Dog(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
