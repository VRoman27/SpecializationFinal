package Programm.Animals;

import java.time.LocalDate;
import java.util.ArrayList;

import Programm.AnimalsEnum;

public abstract class Animal {    

    private int id;
    private String name;
    private LocalDate birthDate;
    private ArrayList<String> commands;
    private String type;
    private String group;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        commands = new ArrayList<String>();
        this.type = this.getClass().getSimpleName();
        this.group = this.getClass().getSuperclass().getSimpleName();
    }

    public Animal(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        commands = new ArrayList<String>();
        this.type = this.getClass().getSimpleName();
        this.group = this.getClass().getSuperclass().getSimpleName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }
    public String getType() {
        return AnimalsEnum.selectType(type);
    }

    public String getGroup() {
        return AnimalsEnum.selectType(group);
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public String showCommands() {
        String commandsText = "Вот, что умеет " + this.name + ":\n";
        StringBuilder text = new StringBuilder(commandsText);
        for (String command : commands) {
            text.append(command + "\n");
        }
        text.append("-".repeat(10) + "\n");
        commandsText = text.toString();
        return commandsText;
    }

    @Override
    public String toString() {
        return this.getGroup() + "\t|" + this.getType() + "\t|" + name + "\t|" + birthDate;
    }

}