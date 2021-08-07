package ru.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.app.model.User;
import ru.app.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {
    boolean check = true;

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String redirect() {


        if (check == true) {
            userService.deleteTable();
            userService.createOrUpdateUser(new User("Филип", "Иванов", "IvPhil@mail.ru"));
            userService.createOrUpdateUser(new User("Наиль", "Алишев", "SpringShifu@mail.ru"));
            userService.createOrUpdateUser(new User("Булат", "Ринчинов", "RBB@mail.ru"));
            userService.createOrUpdateUser(new User("Анна", "Петрова", "AnnaPet@mail.ru"));
            userService.createOrUpdateUser(new User("Игорь", "Павлов", "IgorStar@mail.ru"));
            userService.createOrUpdateUser(new User("Гузель", "Ахметова", "Guzel89@mail.ru"));
            check = false;
        }
        return "redirect:/users";
    }
}


/*







 */