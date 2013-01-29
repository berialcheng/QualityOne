package org.argus.core.route;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class RouteHandler {

	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("success");
	}
	
	public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	}
	
}
