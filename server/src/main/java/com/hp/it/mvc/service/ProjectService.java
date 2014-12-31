package com.hp.it.mvc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.hp.it.mvc.bean.Project;

@Service
public class ProjectService implements IProjectService {

	public Project getProject(String groupId, String artificatId, String branch) {
		String kee = groupId + ":" + artificatId;
		if (branch != null) {
			kee += ":" + branch;
		}

		File workspace = new File(System.getProperty("user.home")
				+ File.separator + ".quality-one" + File.separator
				+ "workspace");
		if (workspace.isDirectory()) {
			for (File project : workspace.listFiles()) {
				if (!project.isDirectory() || !project.getName().replace('$', ':').equalsIgnoreCase(kee)) {
					continue;
				}

				for (File file : project.listFiles()) {
					if (file.isFile()
							&& file.getName().equalsIgnoreCase(
									"config.properties")) {
						try {
							Properties properties = new Properties();
							FileInputStream fis = new FileInputStream(file);
							properties.load(fis);
							fis.close();
							Project p = new Project();
							p.setNamespace(kee);
							Map<String, String> map = new HashMap(properties);
							p.setProperties(map);
							return p;
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				break;
			}
		}
		return null;
	}

	public List<Project> getProjectList() {
		List list = new ArrayList();
		
		File workspace = new File(System.getProperty("user.home")
				+ File.separator + ".quality-one" + File.separator
				+ "workspace");
		if (workspace.isDirectory()) {
			for (File project : workspace.listFiles()) {
				if (!project.isDirectory()) {
					continue;
				}

				for (File file : project.listFiles()) {
					if (file.isFile()
							&& file.getName().equalsIgnoreCase(
									"config.properties")) {
						try {
							Properties properties = new Properties();
							FileInputStream fis = new FileInputStream(file);
							properties.load(fis);
							fis.close();
							Project p = new Project();
							p.setNamespace(project.getName().replace('$', ':'));
							Map<String, String> map = new HashMap(properties);
							p.setProperties(map);
							list.add(p);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return list;
	}

	public void setProject(Project project) {
		// TODO Auto-generated method stub
	}

}
