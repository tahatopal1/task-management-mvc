package com.project.mvcside.controller;

import com.project.mvcside.model.BasicAuth;
import com.project.mvcside.model.wsdto.TaskWsDto;
import com.project.mvcside.model.wsdto.UserWsDto;
import com.project.mvcside.service.TaskService;
import com.project.mvcside.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Controller
public class MainController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaders(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("taskWsDtos", taskService
				.findAll(new BasicAuth(httpServletRequest.getSession().getAttribute("session_username").toString(),
										httpServletRequest.getSession().getAttribute("session_password").toString())));
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

	@RequestMapping("/leaders/update-task")
	public String updateTask(Model model, @RequestParam Integer task_id){
		model.addAttribute("task", taskService.find(task_id));
		model.addAttribute("users",
				userService.findAll().stream().map(UserWsDto::getUsername).collect(Collectors.toList()));
		return "update-task";
	}

	@RequestMapping("/leaders/update-task/place")
	public String placeUpdatedTask(@ModelAttribute TaskWsDto taskWsDto){
		taskService.update(taskWsDto);
		return "redirect:/leaders";
	}

}
