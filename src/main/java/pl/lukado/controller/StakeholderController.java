package pl.lukado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukado.entity.Stakeholder;
import pl.lukado.service.StakeholderService;

@Controller
@RequestMapping("/stakeholder")
public class StakeholderController {

	@Autowired
	StakeholderService stakeholderService;

	@GetMapping("/add")
	public String addStakeholder(Model model) {
		return stakeholderService.addStakeholder(model);

	}

	@PostMapping("/add")
	public String addStakeholder(Stakeholder stakeholder, BindingResult result) {
		return stakeholderService.addStakeholder(stakeholder, result);
	}

	@GetMapping("/all")
	public String allStakeholder(Model model) {
		return stakeholderService.allStakeholder(model);
	}

	@GetMapping("/delete")
	public String deleteStakeholder(long id) {
		return stakeholderService.deleteStakeholder(id);

	}

	@GetMapping("/edit")
	public String editStakeholder(Model model, long id) {
		return stakeholderService.editStakeholder(model, id);
	}

	@PostMapping("/edit")
	public String editStakeholder(Stakeholder stakeholder, BindingResult result) {
		return stakeholderService.editStakeholder(stakeholder, result);
	}
}
