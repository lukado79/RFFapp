package pl.lukado.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pl.lukado.entity.Truck;
import pl.lukado.repository.TruckRepository;

@Service
@Transactional
public class TruckService {

	@Autowired
	TruckRepository truckRepository;

	public String addTruck(Model model) {
		model.addAttribute("truck", new Truck());
		return "add";

	}

	public String addTruck(@Valid @ModelAttribute Truck truck, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		} else {
			truckRepository.save(truck);
			return "return:/truck/all";
		}

	}

	public String allTruck(Model model) {
		model.addAttribute("truck", truckRepository.findAll());
		return "allTruck";
	}

	public String deleteTruck(@PathVariable long id) {
		truckRepository.deleteById(id);
		return "redirect:/truck/all";
	}

	public String editTruck(Model model, @PathVariable long id) {
		Truck truck = truckRepository.findOne(id);
		model.addAttribute("truck", truck);
		return "editTruck";
	}

	public String editTruck(@Valid @ModelAttribute Truck truck, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			truckRepository.save(truck);
			return "return:/truck/all";
		}
	}

}
