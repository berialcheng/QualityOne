package com.hp.it.mvc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.hp.it.mvc.bean.ConfigItem;
import com.hp.it.server.context.ProjectContext;

@Service
public class ConfigItemService implements IConfigItemService {

	public ConfigItem getConfigItem(String coordinate) {
		String kee = null;
		if(coordinate.contains("aggregate")){
			kee = coordinate;
		}else{
			String coorArr[] = coordinate.split(":");
			String groupId = coorArr[0];
			String artificatId = coorArr[1];
			String branch = null;
			if (coorArr.length > 2) {
				branch = coorArr[2];
			}
			kee = groupId + ":" + artificatId;
			if (branch != null) {
				kee += ":" + branch;
			}
		}
		

		File workspace = new File(System.getProperty("user.home")
				+ File.separator + ".quality-one" + File.separator
				+ "workspace");
		if (workspace.isDirectory()) {
			for (File project : workspace.listFiles()) {
				if (!project.isDirectory()
						|| !project.getName().replace('$', ':')
								.equalsIgnoreCase(kee)) {
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
							ConfigItem p = new ConfigItem();
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

	public List<ConfigItem> getConfigItemList() {
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
							ConfigItem p = new ConfigItem();
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

	public boolean saveOrUpdateConfigItem(ConfigItem project) {
		File workspace = new File(System.getProperty("user.home")
				+ File.separator + ".quality-one" + File.separator
				+ "workspace");
		if (workspace.isDirectory()) {
			for (File projectFolder : workspace.listFiles()) {
				if (!projectFolder.isDirectory()
						|| !projectFolder.getName().replace('$', ':')
								.equalsIgnoreCase(project.getNamespace())) {
					continue;
				}
				for (File file : projectFolder.listFiles()) {
					if (file.isFile()
							&& file.getName().equalsIgnoreCase(
									"config.properties")) {
						try {
							Properties properties = new Properties();
							for (Map.Entry<String, String> pair : project
									.getProperties().entrySet()) {
								properties.setProperty(pair.getKey(),
										pair.getValue());
							}

							FileOutputStream fos = new FileOutputStream(file);
							properties.store(fos, "");
							fos.close();
							// ProjectContext.setProperties(req.getParameter("KEE"),
							// properties);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return true;
			}
		}
		return false;
	}
}
