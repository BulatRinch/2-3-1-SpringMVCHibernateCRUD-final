package ru.itsinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itsinfo.model.User;
import ru.itsinfo.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping({"", "/", "list"})
	public String showAllUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute) {
		model.addAttribute("users", userService.getAllUsers());

		return "list";
	}

	@GetMapping(value = "/new")
	public String addUserForm(@ModelAttribute("user") User user) {
		return "form";
	}

	@GetMapping("/{id}/edit")
	public String edidtUserForm(@PathVariable(value = "id", required = true) long id, Model model,
								RedirectAttributes attributes) {
		try {
			model.addAttribute("user", userService.readUser(id));
		} catch (NumberFormatException | NullPointerException e) {
			attributes.addFlashAttribute("flashMessage", "User are not exists!");
			return "redirect:/users";
		}
		return "form";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
						   RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return "form";
		}

		if (0 == user.getId()) {
			userService.createUser(user);
		} else {
			userService.updateUser(user);
		}

		attributes.addFlashAttribute("flashMessage",
				"User " + user.getFirstName() + " successfully created!");
		return "redirect:/users";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") long id,
								   RedirectAttributes attributes) {
		try {
			User user = userService.deleteUser(id);
			attributes.addFlashAttribute("flashMessage",
					"User " + user.getFirstName() + " successfully deleted!");
		} catch (NumberFormatException | NullPointerException e) {
			attributes.addFlashAttribute("flashMessage", "User are not exists!");
		}

		return "redirect:/users";
	}
}