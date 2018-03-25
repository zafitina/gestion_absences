package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Responsable;
import istv.l3.absence.repository.ResponsableRepository;

@Service
public class ResponsableService {

	@Autowired
	private ResponsableRepository ResponsableRepository;

	public Set<Responsable> findAll() {
		return ResponsableRepository.findAll();
	}

	public void save(Responsable Responsable) {
		ResponsableRepository.save(Responsable);
	}

	public void delete(int id) {
		ResponsableRepository.delete(id);
	}

	public Responsable findOne(int id) {
		return ResponsableRepository.findOne(id);
	}
}
