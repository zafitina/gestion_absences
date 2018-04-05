package istv.l3.absence.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Presence;
import istv.l3.absence.model.User;
import istv.l3.absence.repository.PresenceRepository;

@Service
public class PresenceService {

	@Autowired
	private PresenceRepository presenceRepository;
	@Autowired
	private UserService userService;

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

	public Presence findByEtuAndSession(int idsession, int idetudiant) {
		Presence p = null;
		for (Presence presence : findAll()) {
			if (presence.getEtudiant().getId() == idetudiant && presence.getSeance().getId() == idsession) {
				p = presence;
			}
		}
		return p;
	}

	public Set<Presence> findByStudent() {
		Set<Presence> presences = new HashSet<Presence>();
		User user = userService.getLoggedUser();
		for (Presence presence : findAll()) {
			if (presence.getEtudiant().getId() == user.getId() && presence.isPresent() == false) {
				presences.add(presence);
			}
		}
		return presences;
	}

}
