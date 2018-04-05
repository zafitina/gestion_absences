package istv.l3.absence.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Etudiant;
import istv.l3.absence.model.Presence;
import istv.l3.absence.model.Seance;
import istv.l3.absence.model.User;
import istv.l3.absence.service.EtudiantService;
import istv.l3.absence.service.SeanceService;
import istv.l3.absence.service.UserService;

@Controller
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private UserService userService;

	@Autowired
	private SeanceService seanceService;

	private final String url = "/student";

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("etudiant");
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		return model;
	}

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@RequestMapping(value = "/showStudents/{idsession}")
	public ModelAndView showStudent(@PathVariable int idsession) {
		ModelAndView model = new ModelAndView("showStudents");
		Seance seance = seanceService.findOne(idsession);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = url + "/bySession/{idsession}", method = RequestMethod.GET)
	public Set<Etudiant> findBySession(@PathVariable int idsession) {
		return etudiantService.findBySession(idsession);
	}
}
