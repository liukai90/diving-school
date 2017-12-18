package com.drs.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptorLogin implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String url=req.getRequestURI();
		if(url.indexOf("login.action")>=0){
			return true;
		}
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("phone");
		if(username!=null){
			return true;
		}
		req.getRequestDispatcher("index.jsp").forward(req, res);
		return false;
	}


}
