package com.project.mvcside.controller;

import com.project.mvcside.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaders(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		return "leaders";
	}

	@GetMapping("systems")
	public String showSystems() {
		return "systems";
	}
}
