package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Groupe;
import istv.l3.absence.repository.GroupeRepository;

@Service
public class GroupeService {

	@Autowired
	private GroupeRepository groupeRepository;

	public Set<Groupe> findAll() {
		return groupeRepository.findAll();
	}

	public void save(Groupe groupe) {
		groupeRepository.save(groupe);
	}

	public Groupe finOne(int id) {
		return groupeRepository.findOne(id);
	}

	public void delete(int id) {
		groupeRepository.delete(id);
	}
}
