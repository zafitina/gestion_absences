package istv.l3.absence.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import istv.l3.absence.model.Salle;
import istv.l3.absence.service.BatimentService;
import istv.l3.absence.service.SalleService;

@Controller
public class SalleController {

	@Autowired
	private SalleService salleService;

	@Autowired
	private BatimentService batimentService;

	private final String url = "/salle";

	@RequestMapping(value = url + "/byBuilding/{idBat}", method = RequestMethod.GET)
	@ResponseBody
	public Set<Salle> findByBatiment(@PathVariable int idBat) {
		Set<Salle> salles = new HashSet<Salle>();
		for (Salle salle : salleService.findAll()) {
			if (salle.getBatiment().getId() == idBat) {
				salles.add(salle);
			}
		}
		return salles;
	}
}
