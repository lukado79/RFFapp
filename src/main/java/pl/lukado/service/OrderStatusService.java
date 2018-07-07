package pl.lukado.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pl.lukado.entity.OrderStatus;
import pl.lukado.repository.OrderStatusRepository;

@Service
@Transactional
public class OrderStatusService {

	@Autowired
	OrderStatusRepository orderStatusRepository;

	public String addOrderStatus(Model model) {
		model.addAttribute("orderStatus", new OrderStatus());
		return "add";

	}

	public String addOrderStatus(@Valid @ModelAttribute OrderStatus orderStatus, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		} else {
			orderStatusRepository.save(orderStatus);
			return "return:/orderStatus/all";
		}
	}

	public String allOrderStatus(Model model) {
		model.addAttribute("orderStatus", orderStatusRepository.findAll());
		return "allorderStatus";
	}

	public String deleteOrderStatus(@PathVariable long id) {
		orderStatusRepository.deleteById(id);
		return "redirect:/orderStatus/all";
	}

	public String editOrderStatus(Model model, @PathVariable long id) {
		OrderStatus orderStatus = orderStatusRepository.findOne(id);
		model.addAttribute("orderStatus", orderStatus);
		return "editorderStatus";
	}

	public String editOrderStatus(@Valid @ModelAttribute OrderStatus orderStatus, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			orderStatusRepository.save(orderStatus);
			return "return:/orderStatus/all";
		}
	}
}
