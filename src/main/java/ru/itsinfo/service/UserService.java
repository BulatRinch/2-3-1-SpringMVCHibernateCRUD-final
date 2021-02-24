package ru.itsinfo.service;

import org.springframework.stereotype.Service;
import ru.itsinfo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(long id);

    User deleteUser(long parseUnsignedInt);
}
