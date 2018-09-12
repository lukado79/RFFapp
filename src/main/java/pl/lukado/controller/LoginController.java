package pl.lukado.controller;

import javax.servlet.http.HttpSession;

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
	public String login(HttpSession session, Model model) {
		
		session.invalidate();
		model.addAttribute("user", new User());
		
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String password, @RequestParam String email, HttpSession session, Model model) {

		User user;
		user = userService.findByEmail(email);
		session.setAttribute("user", user);
		try {
			if (BCrypt.checkpw(password, user.getPassword()) && "admin".equals(user.getRole().getRoleName())) {

				return "adminView";
			} else if (BCrypt.checkpw(password, user.getPassword()) && "user".equals(user.getRole().getRoleName())) {
				return "forwarderView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
		return "home";
		}

	}

}
