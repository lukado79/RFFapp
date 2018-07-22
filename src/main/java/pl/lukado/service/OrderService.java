package pl.lukado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.lukado.entity.Order;
import pl.lukado.entity.Stakeholder;
import pl.lukado.entity.Truck;
import pl.lukado.entity.User;
import pl.lukado.repository.OrderRepository;
import pl.lukado.repository.StakeholderRepository;
import pl.lukado.repository.TruckRepository;
import pl.lukado.repository.UserRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StakeholderRepository stakeholderRepository;

	@Autowired
	TruckRepository truckRepository;

	public String addOrder(Model model) {
		model.addAttribute("order", new Order());
		return "addOrder";

	}

	public String addOrder(Order order, BindingResult result) {
		if (result.hasErrors()) {
			return "addOrder";
		} else {
			orderRepository.save(order);
			return "redirect:/order/all";
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
			return "redirect:/order/all";
		}
	}

	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public List<Stakeholder> getStakeholder() {
		List<Stakeholder> stakeholder = stakeholderRepository.findAll();
		return stakeholder;
	}

	public List<Truck> getTrucks() {
		List<Truck> truck = truckRepository.findAll();
		return truck;
	}
}
