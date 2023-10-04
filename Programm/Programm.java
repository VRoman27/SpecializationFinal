package Programm;

public class Programm {
    public static void main(String[] args) {

        Nursery nursery = new Nursery();

        Menu menu = new Menu();
        boolean flag =true;
        while (flag) {
            flag = menu.mainMenu(nursery);
        }

    }
}
