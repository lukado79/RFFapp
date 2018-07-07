package pl.lukado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukado.entity.OrderStatus;
import pl.lukado.service.OrderStatusService;

@Controller
@RequestMapping("/orderStatus")
public class OrderStatusController {

	@Autowired
	OrderStatusService orderStatusService;

	@GetMapping("/add")
	public String addOrderStatus(Model model) {
		return orderStatusService.addOrderStatus(model);

	}

	@PostMapping("/add")
	public String addOrderStatus(OrderStatus orderStatus, BindingResult result) {
		return orderStatusService.addOrderStatus(orderStatus, result);
	}

	@GetMapping("/all")
	public String allOrderStatus(Model model) {
		return orderStatusService.allOrderStatus(model);
	}

	@GetMapping("/delete")
	public String deleteOrderStatus(long id) {
		return orderStatusService.deleteOrderStatus(id);

	}

	@GetMapping("/edit")
	public String editOrderStatus(Model model, long id) {
		return orderStatusService.editOrderStatus(model, id);
	}

	@PostMapping("/edit")
	public String editOrderStatus(OrderStatus orderStatus, BindingResult result) {
		return orderStatusService.editOrderStatus(orderStatus, result);
	}

}
