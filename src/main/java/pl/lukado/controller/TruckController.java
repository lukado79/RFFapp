package pl.lukado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String addTruck(Truck truck, BindingResult result) {
		return truckService.addTruck(truck, result);
	}

	@GetMapping("/all")
	public String allTruck(Model model) {
		return truckService.allTruck(model);
	}

	@GetMapping("/delete")
	public String deleteTruck(long id) {
		return truckService.deleteTruck(id);

	}
	
	@GetMapping("/edit")
	public String editTruck(Model model,long id) {
		return truckService.editTruck(model, id);
	}
	
	@PostMapping("/edit")
	public String editTruck(Truck truck, BindingResult result) {
		return truckService.editTruck(truck, result);
	}

}
