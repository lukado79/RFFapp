package pl.lukado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import pl.lukado.entity.Order;
import pl.lukado.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public String addOrder(Model model) {
		model.addAttribute("order", new Order());
		return "addOrder";

	}

	public String addOrder(Order order, BindingResult result) {
		if (result.hasErrors()) {
			return "addOrder";
		} else {
			orderRepository.save(order);
			return "return:/order/all";
		}
	}

	public String allOrder(Model model) {
		model.addAttribute("order", orderRepository.findAll());
		return "allOrder";
	}

	public String deleteOrder(long id) {
		orderRepository.deleteById(id);
		return "redirect:/order/all";
	}

	public String editOrder(Model model, long id) {
		Order order = orderRepository.findOne(id);
		model.addAttribute("order", order);
		return "editOrder";
	}

	public String editOrder(Order order, BindingResult result) {
		if (result.hasErrors()) {
			return "editOrder";
		} else {
			orderRepository.save(order);
			return "return:/order/all";
		}
	}
}
