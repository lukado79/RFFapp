package pl.lukado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukado.entity.User;
import pl.lukado.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/add")
	public String addUser(Model model) {
		return userService.addUser(model);

	}

	@PostMapping("/add")
	public String addUser(@Valid @ModelAttribute User user, BindingResult result) {
		return userService.addUser(user, result);
	}

	@GetMapping("/all")
	public String allUser(Model model) {
		return userService.allUser(model);
	}

	@GetMapping("/delete")
	public String deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);

	}

	@GetMapping("/edit")
	public String editUser(Model model, @PathVariable long id) {
		return userService.editUser(model, id);
	}

	@PostMapping("/edit")
	public String editUser(@Valid @ModelAttribute User user, BindingResult result) {
		return userService.editUser(user, result);
	}
}
