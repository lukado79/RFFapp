package pl.lukado.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.lukado.entity.User;
import pl.lukado.entity.UserRole;
import pl.lukado.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String password, String email, UserRole role, Model model) {
		String roleU = userService.findByEmail(email).getRole().toString();
		if (BCrypt.checkpw(password, userService.findByEmail(email).getPassword()) && roleU == "admin") {
			model.addAttribute("user", email);
			model.addAttribute("user", password);
			model.addAttribute("user", role);
			return "adminView";
		} else if (BCrypt.checkpw(password, userService.findByEmail(email).getPassword()) && roleU == "forwarder") {
			model.addAttribute("user", email);
			model.addAttribute("user", password);
			model.addAttribute("user", role);
			return "forwarderView";
		} else {
			return "wrongLogin";
		}

	}

//	@ModelAttribute("user")
//	public User findByEmail(String email) {
//		return userService.findByEmail(email);
//
//	}
}
