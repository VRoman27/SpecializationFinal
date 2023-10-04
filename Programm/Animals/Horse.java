package Programm.Animals;

import java.time.LocalDate;

public class Horse extends PackAnimal{

    public Horse(String name, LocalDate birth_date) {
        super(name, birth_date);
    }
    public Horse(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
