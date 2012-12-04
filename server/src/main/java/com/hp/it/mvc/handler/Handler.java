package com.hp.it.mvc.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	public Map<String,?> process(HttpServletRequest request, HttpServletResponse response);
}
