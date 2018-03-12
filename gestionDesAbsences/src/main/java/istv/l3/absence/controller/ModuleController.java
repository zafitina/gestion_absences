package istv.l3.absence.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import istv.l3.absence.model.Module;
import istv.l3.absence.service.ModuleService;

@Controller
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	private final String url = "/module";

	@RequestMapping(value=url+"/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Module> findAll() {
		return moduleService.findAll();
	}
}
