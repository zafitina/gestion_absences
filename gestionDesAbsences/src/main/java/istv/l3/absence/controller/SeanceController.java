package istv.l3.absence.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Seance;
import istv.l3.absence.service.BatimentService;
import istv.l3.absence.service.FormationService;
import istv.l3.absence.service.GroupeService;
import istv.l3.absence.service.ModuleService;
import istv.l3.absence.service.ResponsableService;
import istv.l3.absence.service.SalleService;
import istv.l3.absence.service.SeanceService;

@Controller
public class SeanceController {

	@Autowired
	private SeanceService seanceService;

	@Autowired
	private FormationService formationService;

	@Autowired
	private GroupeService groupeService;

	@Autowired
	private ResponsableService responsableService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private BatimentService batimentService;

	@Autowired
	private SalleService salleService;

	private final String url = "/session";

	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("seance");
		return model;
	}

	@RequestMapping(value = "/createSession", method = RequestMethod.GET)
	public ModelAndView createSession() {
		Seance seance = new Seance();
		ModelAndView model = new ModelAndView("createSeance");
		model.addObject("seance", seance);
		model.addObject("formations", formationService.findAll());
		model.addObject("modules", moduleService.findAll());
		model.addObject("professors", responsableService.findAll());
		model.addObject("groupes", groupeService.findAll());
		model.addObject("batiments", batimentService.findAll());
		model.addObject("salles", salleService.findAll());
		return model;
	}

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Seance> findAll() {
		return seanceService.findAll();
	}

	@RequestMapping(value = "/session/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute @Valid Seance seance, BindingResult result) {
		if (result.hasErrors()) {
			System.err.println(result);
		}
		seanceService.save(seance);
		ModelAndView model = new ModelAndView("/sessions");
		return model;
	}
}
