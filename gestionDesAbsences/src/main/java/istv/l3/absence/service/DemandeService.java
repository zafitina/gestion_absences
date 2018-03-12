package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Demande;
import istv.l3.absence.repository.DemandeRepository;

@Service
public class DemandeService {

	@Autowired
	private DemandeRepository demandeRepository;

	public Set<Demande> findAll() {
		return demandeRepository.findAll();
	}

	public void save(Demande demande) {
		demandeRepository.save(demande);
	}

	public Demande findOne(int id) {
		return demandeRepository.findOne(id);
	}

	public void delete(int id) {
		demandeRepository.delete(id);
	}
}
