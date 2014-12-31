package com.hp.it.mvc.service;

import java.util.List;

import com.hp.it.mvc.bean.ConfigItem;


public interface IConfigItemService {
	
	public ConfigItem getConfigItem(String coordinate);
	
	public List<ConfigItem> getConfigItemList();

	public boolean saveOrUpdateConfigItem(ConfigItem project);
	
}
