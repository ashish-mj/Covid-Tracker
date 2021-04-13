package com.CovidTacker.CovidTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	DataService dataservice;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("stats", dataservice.getAllData());
		return "home";
	}

}
