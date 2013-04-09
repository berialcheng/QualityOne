package com.hp.it.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qualityone.utils.Artifact;
import org.qualityone.utils.CoordinateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CoreController {

	@RequestMapping(value = "/{coordinate}/configure", method = RequestMethod.GET)
	public ModelAndView configure(@PathVariable String coordinate, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Artifact artifact = CoordinateUtils.resloveCoordinate(coordinate);
		ModelAndView mav = new ModelAndView("configure");
		request.setAttribute("groupId", artifact.getGroupId());
		request.setAttribute("artifactId", artifact.getArtifactId());
		return new ModelAndView("configure");
	}

	@RequestMapping(value = "/{coordinate}/delete", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable String coordinate, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Artifact artifact = CoordinateUtils.resloveCoordinate(coordinate);
		ModelAndView mav = new ModelAndView("delete");
		return new ModelAndView("delete");
	}
}
