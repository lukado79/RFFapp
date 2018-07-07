package pl.lukado.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pl.lukado.entity.UserRole;
import pl.lukado.repository.UserRoleRepository;

@Service
@Transactional
public class UserRoleService {
	@Autowired
	UserRoleRepository userRoleRepository;

	public String addUserRole(Model model) {
		model.addAttribute("userRole", new UserRole());
		return "add";

	}

	public String addUserRole(@Valid @ModelAttribute UserRole userRole, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		} else {
			userRoleRepository.save(userRole);
			return "return:/userRole/all";
		}
	}

	public String allUserRole(Model model) {
		model.addAttribute("userRole", userRoleRepository.findAll());
		return "allUserRole";
	}

	public String deleteUserRole(@PathVariable long id) {
		userRoleRepository.deleteById(id);
		return "redirect:/userRole/all";
	}

	public String editUserRole(Model model, @PathVariable long id) {
		UserRole userRole = userRoleRepository.findOne(id);
		model.addAttribute("userRole", userRole);
		return "editUserRole";
	}

	public String editUserRole(@Valid @ModelAttribute UserRole userRole, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			userRoleRepository.save(userRole);
			return "return:/userRole/all";
		}
	}

}
