package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import istv.l3.absence.model.Responsable;
import istv.l3.absence.service.ResponsableService;

@Controller
public class ResponsableController {

	@Autowired
	private ResponsableService ResponsableService;

	private final String url = "/professor";

	@RequestMapping(value = "/professors", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("responsable");
		return model;
	}

	@RequestMapping(value = url + "/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Responsable> findAll() {
		return ResponsableService.findAll();
	}
}
