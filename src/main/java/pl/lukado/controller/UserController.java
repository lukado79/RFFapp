package pl.lukado.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import pl.lukado.entity.UserRole;
import pl.lukado.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/add")
	public String addUser(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return userService.addUser(model);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/add")
	public String addUser(@Valid @ModelAttribute User user, BindingResult result, HttpSession session) {

		User userSess;
		userSess = (User) session.getAttribute("user");
		try {
			if ("admin".equals(userSess.getRole().getRoleName())) {
				return userService.addUser(user, result);
			} else if ("user".equals(userSess.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/all")
	public String allUser(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return userService.allUser(model);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return userService.deleteUser(id);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/edit/{id}")
	public String editUser(Model model, @PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return userService.editUser(model, id);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/edit/{id}")
	public String editUser(@Valid @ModelAttribute User user, BindingResult result, HttpSession session) {

		User userSess;
		userSess = (User) session.getAttribute("user");
		try {
			if ("admin".equals(userSess.getRole().getRoleName())) {
				return userService.editUser(user, result);
			} else if ("user".equals(userSess.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@ModelAttribute("userRole")
	public List<UserRole> getUserRole() {
		return userService.getUserRole();

	}
}
