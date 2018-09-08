package pl.lukado.controller;

import java.util.List;

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
import pl.lukado.entity.OrderStatus;
import pl.lukado.entity.Stakeholder;
import pl.lukado.entity.Truck;
import pl.lukado.entity.User;
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

	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable long id) {
		return orderService.deleteOrder(id);

	}

	@GetMapping("/edit/{id}")
	public String editOrder(Model model, @PathVariable long id) {
		return orderService.editOrder(model, id);
	}

	@PostMapping("/edit/{id}")
	public String editOrder(@Valid @ModelAttribute Order order, BindingResult result) {
		return orderService.editOrder(order, result);
	}

	@ModelAttribute("user")
	public List<User> getUsers() {
		return orderService.getUsers();
	}

	@ModelAttribute("carrier")
	public List<Stakeholder> getCarrier(String carrier) {
		carrier = "carrier";
		return orderService.getCarier(carrier);
	}

	@ModelAttribute("client")
	public List<Stakeholder> getClient(String client) {
		client="client";
		return orderService.getClient(client);
	}

	@ModelAttribute("truck")
	public List<Truck> getTrucks() {
		return orderService.getTrucks();
	}

	@ModelAttribute("orderStatus")
	public List<OrderStatus> getOrderStatus() {
		return orderService.getOrderStatus();
	}
}
