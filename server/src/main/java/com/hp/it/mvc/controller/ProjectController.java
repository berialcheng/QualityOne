package com.hp.it.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.it.mvc.bean.Project;
import com.hp.it.mvc.service.IProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@RequestMapping(value = "/{coordinate:.+}", method = RequestMethod.GET)
	@ResponseBody
	public Project getProject(@PathVariable("coordinate") String coordinate,
			ModelMap model) {
		String coorArr[] = coordinate.split(":");
		String groupId = coorArr[0];
		String artificatId = coorArr[1];
		String branch = null;
		if (coorArr.length > 2) {
			branch = coorArr[2];
		}
		return projectService.getProject(groupId, artificatId, branch);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveProject(@PathVariable("coordinate") String coordinate,
			@RequestBody() Project project) {

	}
}
