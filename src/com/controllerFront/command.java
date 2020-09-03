package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface command {

	public String execute(HttpServletRequest request, HttpServletResponse response);
}
