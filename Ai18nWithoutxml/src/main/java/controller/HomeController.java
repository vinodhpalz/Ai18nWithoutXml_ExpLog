package controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value= "/", method= RequestMethod.GET)
	public ModelAndView initView() {
		ModelAndView mv = null;
		try
		{
		int a = 0;
		logger.info("The value of a is " +a);
		System.out.println("Handler Method is called");
		a = 20;
		logger.info("The value of a is " +a);
		mv = new ModelAndView();
		mv.addObject("welcomeMsg", "Welcome to Spring Internationlization Demo");
		mv.setViewName("home");
		logger.info("View Name which is sent is " + mv.getViewName());
		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage());
			logger.error(ex.getClass().getMethods());
		}
		return mv;
	}
}
