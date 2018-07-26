package pl.lukado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.lukado.entity.StakRole;
import pl.lukado.repository.StakRoleRepository;

@Service
@Transactional
public class StakRoleService {

	@Autowired
	StakRoleRepository stakRoleRepository;

	public String addStakRole(Model model) {
		model.addAttribute("stakRole", new StakRole());
		return "addStakRole";

	}

	public String addStakRole(StakRole stakRole, BindingResult result) {
		if (result.hasErrors()) {
			return "addStakRole";
		} else {
			stakRoleRepository.save(stakRole);
			return "redirect:/stakRole/all";
		}
	}

	public String allStakRole(Model model) {
		model.addAttribute("stakRole", stakRoleRepository.findAll());
		return "allStakRole";
	}

	public String deleteStakRole(long id) {
		stakRoleRepository.deleteById(id);
		return "redirect:/stakRole/all";
	}

	public String editStakRole(Model model, long id) {
		StakRole stakRole = stakRoleRepository.findOne(id);
		model.addAttribute("stakRole", stakRole);
		return "editStakRole";
	}

	public String editStakRole(StakRole stakRole, BindingResult result) {
		if (result.hasErrors()) {
			return "editStakRole";
		} else {
			stakRoleRepository.save(stakRole);
			return "redirect:/stakRole/all";
		}
	}

}
