package pl.lukado.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.lukado.entity.User;
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
	public String login(@RequestParam String password, @RequestParam String email, Model model) {

		User user;

		model.addAttribute("user", email);
		model.addAttribute("user", password);

		user = userService.findByEmail(email);
		if (BCrypt.checkpw(password, user.getPassword()) && "admin".equals(user.getRole().getRoleName())) {

			return "adminView";
		} else if (BCrypt.checkpw(password, user.getPassword()) && "forwarder".equals(user.getRole().getRoleName())) {
			return "redirect:/forwarderView";
		} else {
			return "wrongLogin";
		}

	}

}
