package istv.l3.absence.controller;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Admin;
import istv.l3.absence.model.Etudiant;
import istv.l3.absence.model.Event;
import istv.l3.absence.model.Presence;
import istv.l3.absence.model.Responsable;
import istv.l3.absence.model.Seance;
import istv.l3.absence.model.User;
import istv.l3.absence.service.BatimentService;
import istv.l3.absence.service.FormationService;
import istv.l3.absence.service.GroupeService;
import istv.l3.absence.service.ModuleService;
import istv.l3.absence.service.PresenceService;
import istv.l3.absence.service.ResponsableService;
import istv.l3.absence.service.SalleService;
import istv.l3.absence.service.SeanceService;
import istv.l3.absence.service.UserService;

@Controller
public class SeanceController {

	@Autowired
	private PresenceService presenceService;

	@Autowired
	private UserService userService;

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
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		return model;
	}

	@RequestMapping(value = "/{idsession}", method = RequestMethod.GET)
	public ModelAndView showSession(@PathVariable int idsession) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		ModelAndView model = new ModelAndView("showSession");
		Seance seance = seanceService.findOne(idsession);
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		model.addObject("formations", formationService.findAll());
		model.addObject("professor", seance.getResponsable().getNom().toUpperCase());
		model.addObject("date", formatter.format(seance.getDateSeance()));
		model.addObject("heureDeb", seance.getHeureDeb());
		model.addObject("heureFin", seance.getHeureFin());
		model.addObject("module", seance.getModule().getNom());
		model.addObject("typecours", seance.getTypeCours());
		model.addObject("salle", seance.getSalle().getNumero());
		model.addObject("batiment", seance.getSalle().getBatiment().getNom());
		model.addObject("seance", seance);
		return model;
	}

	@RequestMapping(value = "/createSession", method = RequestMethod.GET)
	public ModelAndView createSession() {
		Seance seance = new Seance();
		ModelAndView model = new ModelAndView("createSeance");
		User user = userService.getLoggedUser();
		model.addObject("username", user.getNom().toUpperCase());
		model.addObject("seance", seance);
		model.addObject("modules", moduleService.findAll());
		model.addObject("professors", responsableService.findAll());
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
	public String save(@ModelAttribute @Valid Seance seance, BindingResult result) {
		if (result.hasErrors()) {
			System.err.println(result);
			return "redirect:/createSession";
		}
		seanceService.save(seance);
		return "redirect:/" + seance.getId();
	}

	@RequestMapping(value = url + "/events", method = RequestMethod.GET)
	@ResponseBody
	public Set<Event> getEvents() {
		User currentUser = userService.getLoggedUser();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Set<Event> events = new HashSet<Event>();
		for (Seance seance : seanceService.findAll()) {
			if (currentUser instanceof Responsable) {
				if (seance.getResponsable().getId() == currentUser.getId()) {
					Event e = new Event();
					e.setId((int) seance.getId());
					e.setTitle(seance.getSalle().getBatiment().getNom() + " " + seance.getSalle().getNumero() + " "
							+ seance.getModule().getNom() + " " + seance.getResponsable().getNom().toUpperCase());
					e.setUrl("/" + seance.getId());
					e.setStart(formatter.format(seance.getDateSeance()) + " " + seance.getHeureDeb());
					e.setEnd(formatter.format(seance.getDateSeance()) + " " + seance.getHeureFin());
					e.setColor(e.getColor(seance));
					events.add(e);
				}
			}
			if (currentUser instanceof Admin) {
				Event e = new Event();
				e.setId((int) seance.getId());
				e.setTitle(seance.getSalle().getBatiment().getNom() + " " + seance.getSalle().getNumero() + " "
						+ seance.getModule().getNom() + " " + seance.getResponsable().getNom().toUpperCase());
				e.setUrl("/" + seance.getId());
				e.setStart(formatter.format(seance.getDateSeance()) + " " + seance.getHeureDeb());
				e.setEnd(formatter.format(seance.getDateSeance()) + " " + seance.getHeureFin());
				e.setColor(e.getColor(seance));
				events.add(e);
			}
			if (currentUser instanceof Etudiant) {
				for (Presence presence : seance.getPresences()) {
					if (presence.getEtudiant().getId() == currentUser.getId()) {
						Event e = new Event();
						e.setId((int) seance.getId());
						e.setTitle(seance.getSalle().getBatiment().getNom() + " " + seance.getSalle().getNumero() + " "
								+ seance.getModule().getNom() + " " + seance.getResponsable().getNom().toUpperCase());
						e.setUrl("/" + seance.getId());
						e.setStart(formatter.format(seance.getDateSeance()) + " " + seance.getHeureDeb());
						e.setEnd(formatter.format(seance.getDateSeance()) + " " + seance.getHeureFin());
						e.setColor(e.getColor(seance));
						events.add(e);
					}
				}
			}
		}
		return events;
	}

	@RequestMapping(value = url + "/update/{idsession}", method = RequestMethod.GET)
	public void updateSession(@PathVariable int idsession) {
		Seance seance = seanceService.findOne(idsession);
	}
}
