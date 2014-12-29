package com.hp.it.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.it.sonar.bean.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Project getProject(ModelMap model) {
		Project p = new Project();
		p.setDescription("desc");
		p.setKee("abc");
		p.setName("testname");
		return p;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void post(ModelMap model) {

	}

}
