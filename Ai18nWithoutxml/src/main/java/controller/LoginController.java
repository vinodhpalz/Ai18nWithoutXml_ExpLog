package controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginPage(@RequestParam(value= "error", required = false)String error,
			@RequestParam(value="logout", required= false)String logout, Model model) {
		
		String errorMessage = null;
		if(error !=null) {
			errorMessage = "UserName or Password is incorrect !!!";
		}
		if(logout != null) {
			errorMessage = "You have been successfully logged out !!!";
		}
		model.addAttribute("errorMessage", errorMessage);
		return "login";	
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}
	
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public ModelAndView accessDenied(Principal user) {
		
		ModelAndView mv = new ModelAndView();
		
		if(user != null) {
			mv.addObject("msg",user.getName()+" "+"You do not have permission to access the page!");
		}
		else
		{
			mv.addObject("msg","You do not have permission to access the page!");
		}
		mv.setViewName("403");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
