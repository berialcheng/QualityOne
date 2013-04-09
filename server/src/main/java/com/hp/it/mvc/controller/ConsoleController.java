package com.hp.it.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ConsoleController {

    @RequestMapping(value = "/{groupId}/{artifactId}/configure", method = RequestMethod.GET)
    public ModelAndView configure(@PathVariable String groupId, @PathVariable String artifactId,
            HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView mav = new ModelAndView("configure");
        request.setAttribute("groupId", groupId);
        request.setAttribute("artifactId", artifactId);

        return new ModelAndView("configure");
    }

	@RequestMapping(value = "/{command}", method = RequestMethod.GET)
	public ModelAndView handleRequest(@PathVariable String command, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(command);
		return new ModelAndView(command);
	}
}
