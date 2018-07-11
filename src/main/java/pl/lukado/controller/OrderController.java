package pl.lukado.controller;

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

import pl.lukado.entity.Order;
import pl.lukado.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/add")
	public String addOrder(Model model) {
		return orderService.addOrder(model);

	}

	@PostMapping("/add")
	public String addOrder(@Valid @ModelAttribute Order order, BindingResult result) {
		return orderService.addOrder(order, result);
	}

	@GetMapping("/all")
	public String allOrder(Model model) {
		return orderService.allOrder(model);
	}

	@GetMapping("/delete")
	public String deleteOrder(@PathVariable long id) {
		return orderService.deleteOrder(id);

	}

	@GetMapping("/edit")
	public String editOrder(Model model, @PathVariable long id) {
		return orderService.editOrder(model, id);
	}

	@PostMapping("/edit")
	public String editOrder(@Valid @ModelAttribute Order order, BindingResult result) {
		return orderService.editOrder(order, result);
	}
}
