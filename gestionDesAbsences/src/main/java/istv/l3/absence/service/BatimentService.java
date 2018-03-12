package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Batiment;
import istv.l3.absence.repository.BatimentRepository;

@Service
public class BatimentService {

	@Autowired
	private BatimentRepository batimentRepository;

	public Set<Batiment> findAll() {
		return batimentRepository.findAll();
	}

	public void save(Batiment batiment) {
		batimentRepository.save(batiment);
	}

	public void delete(int id) {
		batimentRepository.delete(id);
	}

	public Batiment findOne(int id) {
		return batimentRepository.findOne(id);
	}
}
