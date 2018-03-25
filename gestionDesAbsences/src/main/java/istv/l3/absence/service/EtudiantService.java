package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Etudiant;
import istv.l3.absence.repository.EtudiantRepository;

@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository EtudiantRepository;

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
}
