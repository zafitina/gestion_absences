package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Etudiant;
import istv.l3.absence.service.EtudiantService;

@Controller
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	private final String url = "/student";

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("etudiant");
		return model;
	}

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Etudiant> findAll() {
		return etudiantService.findAll();
	}
}
