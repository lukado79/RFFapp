package pl.lukado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwarderViewController {

	@GetMapping("/forwarder")
	public String home() {
		return "forwarder";
	}

}
