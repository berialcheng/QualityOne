package com.hp.it.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.it.mvc.bean.ConfigItem;
import com.hp.it.mvc.service.IConfigItemService;

@Controller
@RequestMapping("/config_item")
public class ConfigItemController {

	@Autowired
	private IConfigItemService configItemService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ConfigItem> getConfigItemList(ModelMap model) {
		return configItemService.getConfigItemList();
	}

	@RequestMapping(value = "/{coordinate:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ConfigItem getConfigItem(@PathVariable("coordinate") String coordinate) {
		return configItemService.getConfigItem(coordinate);
	}

	@RequestMapping(value = "/{coordinate:.+}", method = RequestMethod.PUT)
	@ResponseBody
	public String saveConfigItem(@PathVariable("coordinate") String coordinate,
			@RequestBody() ConfigItem project) {
		configItemService.saveOrUpdateConfigItem(project);
		return "success";
	}
}
