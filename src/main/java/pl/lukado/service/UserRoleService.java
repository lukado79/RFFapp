package pl.lukado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.lukado.entity.UserRole;
import pl.lukado.repository.UserRoleRepository;

@Service
@Transactional
public class UserRoleService {
	@Autowired
	UserRoleRepository userRoleRepository;

	public String addUserRole(Model model) {
		model.addAttribute("userRole", new UserRole());
		return "addUserRole";

	}

	public String addUserRole(UserRole userRole, BindingResult result) {
		if (result.hasErrors()) {
			return "addUserRole";
		} else {
			userRoleRepository.save(userRole);
			return "redirect:/userRole/all";
		}
	}

	public String allUserRole(Model model) {
		model.addAttribute("userRole", userRoleRepository.findAll());
		return "allUserRole";
	}

	public String deleteUserRole(long id) {
		userRoleRepository.deleteById(id);
		return "redirect:/userRole/all";
	}

	public String editUserRole(Model model, long id) {
		UserRole userRole = userRoleRepository.findOne(id);
		model.addAttribute("userRole", userRole);
		return "editUserRole";
	}

	public String editUserRole(UserRole userRole, BindingResult result) {
		if (result.hasErrors()) {
			return "editUserRole";
		} else {
			userRoleRepository.save(userRole);
			return "redirect:/userRole/all";
		}
	}
	


}
