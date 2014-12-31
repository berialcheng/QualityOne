package com.hp.it.mvc.service;

import java.util.List;

import com.hp.it.mvc.bean.Project;


public interface IProjectService {
	
	public Project getProject(String groupId, String artificatId, String branch);
	
	public List<Project> getProjectList();

	public void setProject(Project project);
}
