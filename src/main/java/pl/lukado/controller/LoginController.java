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
import pl.lukado.repository.OrderRepository;
import pl.lukado.service.OrderService;
import pl.lukado.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/login")
	public String login(HttpSession session, Model model) {

		try {
			if (session.getAttribute("user") != null) {
				User user;
				user = (User) session.getAttribute("user");
				if ("admin".equals(user.getRole().getRoleName())) {
					return "adminView";
				} else if ("user".equals(user.getRole().getRoleName())) {
					model.addAttribute("orders", orderRepository.findAllByUserId(user.getId()));
					return "forwarderView";
				} else {
					return "wrongLogin";
				}
			} else {
				session.invalidate();
				model.addAttribute("user", new User());

				return "login";
			}
		} catch (NullPointerException e) {
			return "wrongData";
			
		}

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
				model.addAttribute("orders", orderRepository.findAllByUserId(user.getId()));
				return "forwarderView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongLogin";
		}

	}

}
