package Programm.Animals;

import java.time.LocalDate;

public class PackAnimal extends Animal {

    public PackAnimal(String name, LocalDate birth_date) {
        super(name, birth_date);
    }
    public PackAnimal(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
