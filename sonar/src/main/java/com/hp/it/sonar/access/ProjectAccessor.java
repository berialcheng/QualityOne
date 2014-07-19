package com.hp.it.sonar.access;

import java.util.Collection;

import com.hp.it.sonar.bean.Project;

public interface ProjectAccessor
{

	public Project getProjectById(int id);

	public Project getProject(String groupId, String artifactId , String branch);

	public Project getProject(String kee);

	public Project getProject(String groupId, String artifactId, String branch , String qualifiedClassName);

	public Collection<Project> getProjectsByRootId(int rootId);
}