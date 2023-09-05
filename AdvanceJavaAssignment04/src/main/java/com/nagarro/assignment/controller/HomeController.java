package com.nagarro.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment.dao.TShirtDao;
import com.nagarro.assignment.entity.TShirt;
import com.nagarro.assignment.entity.User;
import com.nagarro.assignment.service.TShirtService;
import com.nagarro.assignment.service.UserService;
import com.nagarro.assignment.util.DataLoader;

@Controller
@SessionAttributes(value = { "user" })
public class HomeController {
	@Autowired
	private UserService userService;

	@Autowired
	private TShirtService tShirtService;

	@PostMapping("/login")
	public String home(@RequestParam("uname") String username, @RequestParam("password") String password, Model model) {
		// ModelAndView model = new ModelAndView("homepage");
		User user = new User(username, password);
		if (this.userService.verifyUserDetails(user)) {
			model.addAttribute("user", user);
			return "redirect:homepage";
		}

		return "index";
	}

	@RequestMapping("/homepage")
	public ModelAndView userDashboard(HttpSession session, Model model) {

//		List<TShirt> shirts = new DataLoader().loader();
//		dao.loadItemsIntoDB(shirts);

		System.out.println((User) session.getAttribute("user"));

		List<TShirt> tshirtList = tShirtService.loadAll();
		model.addAttribute("list", tshirtList);
		return new ModelAndView("homepage");
	}

	@GetMapping("/search")
	public ModelAndView searchCriteria(@RequestParam("color") String color, @RequestParam("size") String size,
			@RequestParam("gender") String gender, @RequestParam("outputPreference") String output, Model model) {
		
		int outputPreference = Integer.parseInt(output);
		TShirt shirt = new TShirt(color, gender, size, outputPreference);
		List<TShirt> list = this.tShirtService.searchByCriteria(shirt);
		model.addAttribute("list", list);
		return new ModelAndView("homepage");
	}

}
