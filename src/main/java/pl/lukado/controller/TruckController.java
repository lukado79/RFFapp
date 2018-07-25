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

import pl.lukado.entity.Truck;
import pl.lukado.service.TruckService;

@Controller
@RequestMapping("/truck")
public class TruckController {

	@Autowired
	TruckService truckService;

	@GetMapping("/add")
	public String addTruck(Model model) {
		return truckService.addTruck(model);

	}

	@PostMapping("/add")
	public String addTruck(@Valid @ModelAttribute Truck truck, BindingResult result) {
		return truckService.addTruck(truck, result);
	}

	@GetMapping("/all")
	public String allTruck(Model model) {
		return truckService.allTruck(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteTruck(@PathVariable long id) {
		return truckService.deleteTruck(id);

	}
	
	@GetMapping("/edit/{id}")
	public String editTruck(Model model,@PathVariable long id) {
		return truckService.editTruck(model, id);
	}
	
	@PostMapping("/edit/{id}")
	public String editTruck(@Valid @ModelAttribute Truck truck, BindingResult result) {
		return truckService.editTruck(truck, result);
	}

}
