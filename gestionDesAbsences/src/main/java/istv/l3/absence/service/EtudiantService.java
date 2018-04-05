package istv.l3.absence.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Etudiant;
import istv.l3.absence.model.Presence;
import istv.l3.absence.model.Seance;
import istv.l3.absence.repository.EtudiantRepository;

@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository EtudiantRepository;

	@Autowired
	private SeanceService seanceService;

	public Set<Etudiant> findAll() {
		return EtudiantRepository.findAll();
	}

	public void save(Etudiant Etudiant) {
		EtudiantRepository.save(Etudiant);
	}

	public void delete(int id) {
		EtudiantRepository.delete(id);
	}

	public Etudiant findOne(int id) {
		return EtudiantRepository.findOne(id);
	}

	public Set<Etudiant> findBySession(int idsession) {
		Set<Etudiant> etudiants = new HashSet<Etudiant>();
		Seance seance = seanceService.findOne(idsession);
		for (Presence presence : seance.getPresences()) {
			etudiants.add(presence.getEtudiant());
		}
		return etudiants;
	}
}
