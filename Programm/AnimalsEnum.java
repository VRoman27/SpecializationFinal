/*
 * AnimalsEnum хранит названия классов в удобном для пользователя виде
 */

package Programm;

public enum AnimalsEnum {
    CAT("Кошка"),
    DOG("Собака"),
    HAMSTER("Хомяк"),
    HORSE("Лошадь"),
    CAMEL("Верблюд"),
    DONKEY("Осёл"),
    PET("Домашний"),
    PACKANIMAL("Вьючный"),
    ANIMAL("Животное");
    private String animal;
    AnimalsEnum(String animal){
        this.animal = animal;
    }
    public String getType(){
        return animal;
    }

    public static String selectType(String text){
        String value = text.toUpperCase();
        for (AnimalsEnum item : AnimalsEnum.values()) {
            if (item.name().equals(value)) {
                return item.getType();
            }
        }
        return ANIMAL.getType();
    }
}
