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

import istv.l3.absence.model.Presence;
import istv.l3.absence.model.User;
import istv.l3.absence.service.EtudiantService;
import istv.l3.absence.service.PresenceService;
import istv.l3.absence.service.SeanceService;
import istv.l3.absence.service.UserService;

@Controller
public class PresenceController {

	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private SeanceService seanceService;

	@Autowired
	private PresenceService presenceService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/presences", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("presence");
		model.addObject("absences", presenceService.findByStudent());
		return model;
	}

	@RequestMapping(value = "/{idsession}/{idetudiant}/editPresence", method = RequestMethod.POST)
	public void setPresence(@PathVariable int idsession, @PathVariable int idetudiant) {
		Presence presence = presenceService.findByEtuAndSession(idsession, idetudiant);
		presence.setPresent(false);
		presenceService.save(presence);
	}
}
