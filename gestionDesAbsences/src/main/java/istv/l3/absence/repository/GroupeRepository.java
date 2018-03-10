package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Groupe;

public interface GroupeRepository extends CrudRepository<Groupe, Long> {

	public Groupe save(Groupe groupe);

	public Groupe findOne(long id);

	public Set<Groupe> findAll();

	public void delete(long id);
}
