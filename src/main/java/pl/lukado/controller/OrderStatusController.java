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
	public String addOrderStatus(@Valid @ModelAttribute OrderStatus orderStatus, BindingResult result) {
		return orderStatusService.addOrderStatus(orderStatus, result);
	}

	@GetMapping("/all")
	public String allOrderStatus(Model model) {
		return orderStatusService.allOrderStatus(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteOrderStatus(@PathVariable long id) {
		return orderStatusService.deleteOrderStatus(id);

	}

	@GetMapping("/edit/{id}")
	public String editOrderStatus(Model model, @PathVariable long id) {
		return orderStatusService.editOrderStatus(model, id);
	}

	@PostMapping("/edit/{id}")
	public String editOrderStatus(@Valid @ModelAttribute OrderStatus orderStatus, BindingResult result) {
		return orderStatusService.editOrderStatus(orderStatus, result);
	}

}
