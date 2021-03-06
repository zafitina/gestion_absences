package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Admin;
import istv.l3.absence.model.User;
import istv.l3.absence.service.AdminService;
import istv.l3.absence.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService AdminService;

	private final String url = "/admin";

	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("admin");
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		return model;
	}

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Admin> findAll() {
		return AdminService.findAll();
	}
}
