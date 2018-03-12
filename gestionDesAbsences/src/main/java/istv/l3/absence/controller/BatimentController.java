package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import istv.l3.absence.model.Batiment;
import istv.l3.absence.service.BatimentService;

@Controller
public class BatimentController {

	@Autowired
	private BatimentService batimentService;

	private final String url = "/building";

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Batiment> findAll() {
		return batimentService.findAll();
	}
}