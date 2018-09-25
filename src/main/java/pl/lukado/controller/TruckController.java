package pl.lukado.controller;

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

import pl.lukado.entity.Truck;
import pl.lukado.entity.User;
import pl.lukado.service.TruckService;

@Controller
@RequestMapping("/truck")
public class TruckController {

	@Autowired
	TruckService truckService;

	@GetMapping("/add")
	public String addTruck(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return truckService.addTruck(model);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/add")
	public String addTruck(@Valid @ModelAttribute Truck truck, BindingResult result, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return truckService.addTruck(truck, result);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/all")
	public String allTruck(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return truckService.allTruck(model);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/delete/{id}")
	public String deleteTruck(@PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return truckService.deleteTruck(id);
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
	public String editTruck(Model model, @PathVariable long id, HttpSession session) {
		
		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return truckService.editTruck(model, id);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}
	
	}

	@PostMapping("/edit/{id}")
	public String editTruck(@Valid @ModelAttribute Truck truck, BindingResult result, HttpSession session) {
		
		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return truckService.editTruck(truck, result);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}
		
	}

}
