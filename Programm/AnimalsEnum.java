package Programm;

public enum AnimalsEnum {
    CAT("кошка"),
    DOG("собака"),
    HAMSTER("хомяк"),
    HORSE("лошадь"),
    CAMEL("верблюд"),
    DONKEY("осёл"),
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
