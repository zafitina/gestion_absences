package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Module;
import istv.l3.absence.model.User;
import istv.l3.absence.service.ModuleService;
import istv.l3.absence.service.UserService;

@Controller
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private UserService userService;

	private final String url = "/module";

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("module");
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		return model;
	}

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Module> findAll() {
		return moduleService.findAll();
	}
}
