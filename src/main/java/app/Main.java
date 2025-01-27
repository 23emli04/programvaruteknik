package app;

import controller.Controller;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addUser(12,"erik");
        System.out.println("Dao klar!");
    }
}