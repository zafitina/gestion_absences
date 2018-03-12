package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Presence;
import istv.l3.absence.repository.PresenceRepository;

@Service
public class PresenceService {

	@Autowired
	private PresenceRepository presenceRepository;

	public Set<Presence> findAll() {
		return presenceRepository.findAll();
	}

	public Presence findOne(int id) {
		return presenceRepository.findOne(id);
	}

	public Presence save(Presence presence) {
		return presenceRepository.save(presence);
	}

	public void delete(int id) {
		presenceRepository.delete(id);
	}
}
