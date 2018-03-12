package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Salle;
import istv.l3.absence.repository.SalleRepository;

@Service
public class SalleService {

	@Autowired
	private SalleRepository salleRepository;

	public Set<Salle> findAll() {
		return salleRepository.findAll();
	}

	public Salle findOne(int id) {
		return salleRepository.findOne(id);
	}

	public void save(Salle salle) {
		salleRepository.save(salle);
	}

	public void delete(int id) {
		salleRepository.delete(id);
	}
}
