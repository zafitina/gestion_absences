package istv.l3.absence.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import istv.l3.absence.model.Groupe;
import istv.l3.absence.service.FormationService;
import istv.l3.absence.service.GroupeService;

@Controller
public class GroupeController {

	@Autowired
	private GroupeService groupeService;

	@Autowired
	private FormationService formationService;

	private final String url = "/groupe";

	@RequestMapping(value = url + "/byFormation/{idFormation}", method = RequestMethod.GET)
	@ResponseBody
	public Set<Groupe> findByFormation(@PathVariable int idFormation) {
		Set<Groupe> groupes = new HashSet<Groupe>();
		for (Groupe groupe : groupeService.findAll()) {
			if (groupe.getFormation().getId() == idFormation) {
				groupes.add(groupe);
			}
		}
		return groupes;
	}
}
