package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Seance;
import istv.l3.absence.repository.SeanceRepository;

@Service
public class SeanceService {

	@Autowired
	private SeanceRepository seanceRepository;

	public Set<Seance> findAll() {
		return seanceRepository.findAll();
	}

	public Seance findOne(int id) {
		return seanceRepository.findOne(id);
	}

	public void save(Seance seance) {
		seanceRepository.save(seance);
	}

	public void delete(int id) {
		seanceRepository.delete(id);
	}
}
