package pl.lukado.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pl.lukado.entity.User;
import pl.lukado.entity.UserRole;
import pl.lukado.repository.UserRepository;
import pl.lukado.repository.UserRoleRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";

	}

	public String addUser(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			return "addUser";
		} else {
			userRepository.save(user);
			return "return:/user/all";
		}
	}

	public String allUser(Model model) {
		model.addAttribute("user", userRepository.findAll());
		return "allUser";
	}

	public String deleteUser(@PathVariable long id) {
		userRepository.deleteById(id);
		return "redirect:/user/all";
	}

	public String editUser(Model model, @PathVariable long id) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "editUser";
	}

	public String editUser(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			return "editUser";
		} else {
			userRepository.save(user);
			return "return:/user/all";
		}
	}

	public User findByEmail(String email) {
		User userFind = userRepository.findFirstByEmail(email);
		return userFind;
	}

	public List<UserRole> getUserRole() {
		List<UserRole> userRole = userRoleRepository.findAll();
		return userRole;
	}

}
