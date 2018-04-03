package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Batiment;
import istv.l3.absence.model.User;
import istv.l3.absence.service.BatimentService;
import istv.l3.absence.service.UserService;

@Controller
public class BatimentController {

	@Autowired
	private BatimentService batimentService;
	
	@Autowired 
	private UserService userService;

	private final String url = "/building";

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Batiment> findAll() {
		return batimentService.findAll();
	}

	@RequestMapping(value = "/buildings", method = RequestMethod.GET)
	public ModelAndView homeBatiment() {
		ModelAndView model = new ModelAndView("batiment");
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		model.addObject("title", "Bâtiment");
		return model;
	}
}
