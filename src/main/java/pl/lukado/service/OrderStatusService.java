package pl.lukado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.lukado.entity.OrderStatus;
import pl.lukado.repository.OrderStatusRepository;

@Service
@Transactional
public class OrderStatusService {

	@Autowired
	OrderStatusRepository orderStatusRepository;

	public String addOrderStatus(Model model) {
		model.addAttribute("orderStatus", new OrderStatus());
		return "addOrderStatus";

	}

	public String addOrderStatus(OrderStatus orderStatus, BindingResult result) {
		if (result.hasErrors()) {
			return "addOrderStatus";
		} else {
			orderStatusRepository.save(orderStatus);
			return "return:/orderStatus/all";
		}
	}

	public String allOrderStatus(Model model) {
		model.addAttribute("orderStatus", orderStatusRepository.findAll());
		return "allOrderStatus";
	}

	public String deleteOrderStatus(long id) {
		orderStatusRepository.deleteById(id);
		return "redirect:/orderStatus/all";
	}

	public String editOrderStatus(Model model, long id) {
		OrderStatus orderStatus = orderStatusRepository.findOne(id);
		model.addAttribute("orderStatus", orderStatus);
		return "editOrderStatus";
	}

	public String editOrderStatus(OrderStatus orderStatus, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			orderStatusRepository.save(orderStatus);
			return "return:/orderStatus/all";
		}
	}
}
