package repository;

import model.User;

public interface IUserRepository {
    void addInfos();
    void show();
    void edit();
    void deleter();
    User checkUser();
}
