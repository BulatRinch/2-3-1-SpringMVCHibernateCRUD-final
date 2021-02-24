package ru.itsinfo.service;

import org.springframework.stereotype.Service;
import ru.itsinfo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
}
