package com.project.mvcside.controller;

import com.project.mvcside.model.BasicAuth;
import com.project.mvcside.model.wsdto.TaskWsDto;
import com.project.mvcside.model.wsdto.UserWsDto;
import com.project.mvcside.service.TaskService;
import com.project.mvcside.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
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
	public String showHome(HttpServletRequest request) {
		if (!ObjectUtils.isEmpty(request.getSession().getAttribute("session_username"))){
			request.getSession().setAttribute("user", userService.findByUsername(
					request.getSession().getAttribute("session_username").toString()
			));
			request.getSession().removeAttribute("session_username");
			request.getSession().removeAttribute("session_password");
		}
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaders(Model model, HttpServletRequest httpServletRequest) {
		UserWsDto user = (UserWsDto) httpServletRequest.getSession().getAttribute("user");
		model.addAttribute("taskWsDtos", taskService.findAll(new BasicAuth(user.getUsername(), user.getPassword())));
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
	public String placeTask(@ModelAttribute TaskWsDto taskWsDto, @RequestParam Integer id){
		taskService.createTask(taskWsDto, id);
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
