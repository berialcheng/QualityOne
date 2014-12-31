package com.hp.it.mvc.bean;

import java.util.Map;

public class Project {
	
	private String namespace;
	
	private Map<String, String> properties;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
}
