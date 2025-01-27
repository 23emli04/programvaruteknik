package controller;

import dao.PersonDAO;

public class Controller {

    public void addUser(int age,String student){
        PersonDAO.getInstance().addPerson(age, student);
    }
}
