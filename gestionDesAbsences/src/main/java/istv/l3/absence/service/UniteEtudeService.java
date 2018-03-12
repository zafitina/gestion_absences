package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.UniteEtude;
import istv.l3.absence.repository.UniteEtudeRepository;

@Service
public class UniteEtudeService {

	@Autowired
	private UniteEtudeRepository uniteEtudeRepository;

	public Set<UniteEtude> findAll() {
		return uniteEtudeRepository.findAll();
	}

	public UniteEtude findOne(int id) {
		return uniteEtudeRepository.findOne(id);
	}

	public void save(UniteEtude uniteEtude) {
		uniteEtudeRepository.save(uniteEtude);
	}

	public void delete(int id) {
		uniteEtudeRepository.delete(id);
	}
}
