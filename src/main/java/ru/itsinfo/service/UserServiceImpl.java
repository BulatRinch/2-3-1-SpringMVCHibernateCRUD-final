package ru.itsinfo.service;

import org.springframework.stereotype.Service;
import ru.itsinfo.dao.UserDAO;
import ru.itsinfo.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println(userDAO.getAllUsers());
        return userDAO.getAllUsers();
    }
}
