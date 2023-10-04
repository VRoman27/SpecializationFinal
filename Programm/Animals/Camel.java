package Programm.Animals;

import java.time.LocalDate;

public class Camel extends PackAnimal {

    public Camel(String name, LocalDate birth_date) {
        super(name, birth_date);
    }

    public Camel(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
