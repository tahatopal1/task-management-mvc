package com.project.mvcside.controller;

import com.project.mvcside.model.TaskWsDto;
import com.project.mvcside.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		model.addAttribute("taskWsDtos", taskService.findAll());
		return "leaders";
	}

	@RequestMapping("systems")
	public String showSystems() {
		return "systems";
	}

	@RequestMapping(value = "/leaders/create-task", method = RequestMethod.GET)
	public String createTask(Model model){
		model.addAttribute("taskWsDto", new TaskWsDto());
		return "create-task";
	}

	@RequestMapping("/leaders/create-task/place")
	public String placeTask(@ModelAttribute TaskWsDto taskWsDto, @RequestParam String username){
		taskService.createTask(taskWsDto, username);
		return "redirect:/leaders";
	}

}
