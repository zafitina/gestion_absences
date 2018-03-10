package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Salle;

public interface SalleRepository extends CrudRepository<Salle, Long> {

	public Salle save(Salle salle);

	public Salle findOne(long id);

	public Set<Salle> findAll();

	public void delete(long id);
}
