package pl.lukado.controller;

import javax.servlet.http.HttpSession;
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

import pl.lukado.entity.StakRole;
import pl.lukado.entity.User;
import pl.lukado.service.StakRoleService;

@Controller
@RequestMapping("/stakRole")
public class StakRoleController {

	@Autowired
	StakRoleService stakRoleService;

	@GetMapping("/add")
	public String addStakRole(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakRoleService.addStakRole(model);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/add")
	public String addStakRole(@Valid @ModelAttribute StakRole stakRole, BindingResult result, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakRoleService.addStakRole(stakRole, result);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/all")
	public String allStakRole(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakRoleService.allStakRole(model);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/delete/{id}")
	public String deleteStakRole(@PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakRoleService.deleteStakRole(id);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/edit/{id}")
	public String editStakRole(Model model, @PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakRoleService.editStakRole(model, id);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/edit/{id}")
	public String editStakRole(@Valid @ModelAttribute StakRole stakRole, BindingResult result, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakRoleService.editStakRole(stakRole, result);
			} else if ("user".equals(user.getRole().getRoleName())) {
				return "accessView";
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}
		
	}

}
