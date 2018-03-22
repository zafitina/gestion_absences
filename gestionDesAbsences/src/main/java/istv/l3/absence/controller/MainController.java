package istv.l3.absence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.User;
import istv.l3.absence.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView("welcomePage");
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom() + " " + user.getPrenom());
		model.addObject("title", "Welcome");
		model.addObject("message", "This is welcome page!");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("loginPage");
		return model;
	}
}

