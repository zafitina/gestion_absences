package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.UniteEtude;

public interface UniteEtudeRepository extends CrudRepository<UniteEtude, Long> {

	public UniteEtude save(UniteEtude uniteEtude);

	public Set<UniteEtude> findAll();

	public UniteEtude findOne(long id);

	public void delete(long id);
}
