package Programm.Animals;

import java.time.LocalDate;

public class Donkey extends PackAnimal{

    public Donkey(String name, LocalDate birth_date) {
        super(name, birth_date);
    }
    public Donkey(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }
    
}
