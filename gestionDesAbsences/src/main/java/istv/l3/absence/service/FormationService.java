package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Formation;
import istv.l3.absence.repository.FormationRepository;

@Service
public class FormationService {

	@Autowired
	private FormationRepository formationRepository;

	public Set<Formation> findAll() {
		return formationRepository.findAll();
	}

	public void save(Formation formation) {
		formationRepository.save(formation);
	}

	public Formation findOne(int id) {
		return formationRepository.findOne(id);
	}

	public void delete(int id) {
		formationRepository.delete(id);
	}
}
