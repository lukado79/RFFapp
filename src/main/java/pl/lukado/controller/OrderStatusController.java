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

import pl.lukado.entity.OrderStatus;
import pl.lukado.entity.User;
import pl.lukado.service.OrderStatusService;

@Controller
@RequestMapping("/orderStatus")
public class OrderStatusController {

	@Autowired
	OrderStatusService orderStatusService;

	@GetMapping("/add")
	public String addOrderStatus(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return orderStatusService.addOrderStatus(model);
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
	public String addOrderStatus(@Valid @ModelAttribute OrderStatus orderStatus, BindingResult result,
			HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return orderStatusService.addOrderStatus(orderStatus, result);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/all")
	public String allOrderStatus(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return orderStatusService.allOrderStatus(model);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/delete/{id}")
	public String deleteOrderStatus(@PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return orderStatusService.deleteOrderStatus(id);
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
	public String editOrderStatus(Model model, @PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return orderStatusService.editOrderStatus(model, id);
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
	public String editOrderStatus(@Valid @ModelAttribute OrderStatus orderStatus, BindingResult result, HttpSession session) {
		
		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return orderStatusService.editOrderStatus(orderStatus, result);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}
		
	}

}
