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
import pl.lukado.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String password, String email, UserRole role, Model model) {
		String roleU = userRepository.findFirstByEmail(email).getRole().toString();
		if (BCrypt.checkpw(password, userRepository.findFirstByEmail(email).getPassword())
				&& roleU == "admin") {
			model.addAttribute("user", email);
			model.addAttribute("user", password);
			model.addAttribute("user", role);
			return "adminView";
		} else if (BCrypt.checkpw(password, userRepository.findFirstByEmail(email).getPassword())
				&& roleU == "forwarder") {
			model.addAttribute("user", email);
			model.addAttribute("user", password);
			model.addAttribute("user", role);
			return "forwarderView";
		} else {
			return "wrongLogin";
		}

	}

}
