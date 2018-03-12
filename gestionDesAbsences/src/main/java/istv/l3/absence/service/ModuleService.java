package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Module;
import istv.l3.absence.repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	public Set<Module> findAll() {
		return moduleRepository.findAll();
	}

	public Module findOne(int id) {
		return moduleRepository.findOne(id);
	}

	public void save(Module module) {
		moduleRepository.save(module);
	}

	public void delete(int id) {
		moduleRepository.delete(id);
	}
}
