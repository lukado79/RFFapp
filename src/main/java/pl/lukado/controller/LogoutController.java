package pl.lukado.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping("logout")
	public String logout(HttpSession session) {

		try {
			if (session.getAttribute("user") != null) {
				session.invalidate();
				return "logout";
			} else {
				return "home";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

}
