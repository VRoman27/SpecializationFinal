package Programm.Animals;

import java.time.LocalDate;

public class Hamster extends Pet{

    public Hamster(String name, LocalDate birth_date) {
        super(name, birth_date);
    }

    public Hamster(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
