package pl.lukado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukado.entity.UserRole;
import pl.lukado.service.UserRoleService;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	
	@Autowired
	UserRoleService userRoleService;
	
	@GetMapping("/add")
	public String addUserRole(Model model) {
		return userRoleService.addUserRole(model);

	}

	@PostMapping("/add")
	public String addUserRole(UserRole userRole, BindingResult result) {
		return userRoleService.addUserRole(userRole, result);
	}

	@GetMapping("/all")
	public String allUserRole(Model model) {
		return userRoleService.allUserRole(model);
	}

	@GetMapping("/delete")
	public String deleteUserRole(long id) {
		return userRoleService.deleteUserRole(id);

	}
	
	@GetMapping("/edit")
	public String editUserRole(Model model,long id) {
		return userRoleService.editUserRole(model, id);
	}
	
	@PostMapping("/edit")
	public String editUserRole(UserRole userRole, BindingResult result) {
		return userRoleService.editUserRole(userRole, result);
	}

}
