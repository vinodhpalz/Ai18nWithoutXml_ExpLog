package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside pre handle");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		Thread.sleep(10000);
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		
		long endTime = System.currentTimeMillis();
		modelAndView.addObject("totalTime", endTime - startTime);
		
		System.out.println("Request Processing Time :: "+ (endTime-startTime));
		Thread.sleep(10000);
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("View Rendered !");
	
	}

	
	
}
