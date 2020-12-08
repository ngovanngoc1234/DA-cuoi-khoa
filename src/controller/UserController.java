package controller;

import model.User;

public interface UserController {
    void addInfos();
    void show();
    void edit();
    void deleter();
    User checkUser();
}
