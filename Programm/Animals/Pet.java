package Programm.Animals;

import java.time.LocalDate;

public class Pet extends Animal{

    public Pet(String name, LocalDate birth_date) {
        super(name, birth_date);
    }

    public Pet(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
