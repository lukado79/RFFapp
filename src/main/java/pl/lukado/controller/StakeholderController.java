package pl.lukado.controller;

import java.util.List;

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
import pl.lukado.entity.Stakeholder;
import pl.lukado.entity.User;
import pl.lukado.service.StakeholderService;

@Controller
@RequestMapping("/stakeholder")
public class StakeholderController {

	@Autowired
	StakeholderService stakeholderService;

	@GetMapping("/add")
	public String addStakeholder(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return stakeholderService.addStakeholder(model);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/add")
	public String addStakeholder(@Valid @ModelAttribute Stakeholder stakeholder, BindingResult result,
			HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return stakeholderService.addStakeholder(stakeholder, result);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/all")
	public String allStakeholder(Model model, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return stakeholderService.allStakeholder(model);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@GetMapping("/delete/{id}")
	public String deleteStakeholder(@PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName())) {
				return stakeholderService.deleteStakeholder(id);
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
	public String editStakeholder(Model model, @PathVariable long id, HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return stakeholderService.editStakeholder(model, id);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@PostMapping("/edit/{id}")
	public String editStakeholder(@Valid @ModelAttribute Stakeholder stakeholder, BindingResult result,
			HttpSession session) {

		User user;
		user = (User) session.getAttribute("user");
		try {
			if ("admin".equals(user.getRole().getRoleName()) || "user".equals(user.getRole().getRoleName())) {
				return stakeholderService.editStakeholder(stakeholder, result);
			} else {
				return "wrongLogin";
			}
		} catch (NullPointerException e) {
			return "wrongData";
		}

	}

	@ModelAttribute("stakRole")
	public List<StakRole> getStakRole() {
		return stakeholderService.getStakRole();

	}
}
