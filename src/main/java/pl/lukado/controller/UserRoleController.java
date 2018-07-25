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
	public String addUserRole(@Valid @ModelAttribute UserRole userRole, BindingResult result) {
		return userRoleService.addUserRole(userRole, result);
	}

	@GetMapping("/all")
	public String allUserRole(Model model) {
		return userRoleService.allUserRole(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteUserRole(@PathVariable long id) {
		return userRoleService.deleteUserRole(id);

	}
	
	@GetMapping("/edit/{id}")
	public String editUserRole(Model model,@PathVariable long id) {
		return userRoleService.editUserRole(model, id);
	}
	
	@PostMapping("/edit/{id}")
	public String editUserRole(@Valid @ModelAttribute UserRole userRole, BindingResult result) {
		return userRoleService.editUserRole(userRole, result);
	}

}
