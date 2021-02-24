package ru.itsinfo.dao;

import ru.itsinfo.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
}
