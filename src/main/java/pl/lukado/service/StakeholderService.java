package pl.lukado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.lukado.entity.Stakeholder;
import pl.lukado.repository.StakeholderRepository;

@Service
@Transactional
public class StakeholderService {

	@Autowired
	StakeholderRepository stakeholderRepository;

	public String addStakeholder(Model model) {
		model.addAttribute("stakeholder", new Stakeholder());
		return "add";

	}

	public String addStakeholder(Stakeholder stakeholder, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		} else {
			stakeholderRepository.save(stakeholder);
			return "return:/stakeholder/all";
		}
	}

	public String allStakeholder(Model model) {
		model.addAttribute("stakeholder", stakeholderRepository.findAll());
		return "allStakeholder";
	}

	public String deleteStakeholder(long id) {
		stakeholderRepository.deleteById(id);
		return "redirect:/stakeholder/all";
	}

	public String editStakeholder(Model model, long id) {
		Stakeholder stakeholder = stakeholderRepository.findOne(id);
		model.addAttribute("stakeholder", stakeholder);
		return "editstakeholder";
	}

	public String editStakeholder(Stakeholder stakeholder, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			stakeholderRepository.save(stakeholder);
			return "return:/stakeholder/all";
		}
	}

}
