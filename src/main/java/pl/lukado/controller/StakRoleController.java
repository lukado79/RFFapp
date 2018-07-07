package pl.lukado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukado.entity.StakRole;
import pl.lukado.service.StakRoleService;

@Controller
@RequestMapping("/stakRole")
public class StakRoleController {

	@Autowired
	StakRoleService stakRoleService;

	@GetMapping("/add")
	public String addStakRole(Model model) {
		return stakRoleService.addStakRole(model);

	}

	@PostMapping("/add")
	public String addStakRole(StakRole stakRole, BindingResult result) {
		return stakRoleService.addStakRole(stakRole, result);
	}

	@GetMapping("/all")
	public String allStakRole(Model model) {
		return stakRoleService.allStakRole(model);
	}

	@GetMapping("/delete")
	public String deleteStakRole(long id) {
		return stakRoleService.deleteStakRole(id);

	}

	@GetMapping("/edit")
	public String editStakRole(Model model, long id) {
		return stakRoleService.editStakRole(model, id);
	}

	@PostMapping("/edit")
	public String editStakRole(StakRole stakRole, BindingResult result) {
		return stakRoleService.editStakRole(stakRole, result);
	}

}
