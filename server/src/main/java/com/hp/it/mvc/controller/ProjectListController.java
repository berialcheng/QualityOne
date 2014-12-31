package com.hp.it.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.it.mvc.bean.Project;
import com.hp.it.mvc.service.IProjectService;

@Controller
@RequestMapping("/project_list")
public class ProjectListController {
	
	@Autowired
	private IProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Project> getProject(ModelMap model) {
		return projectService.getProjectList();
	}
}
