package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Seance;

public interface SeanceRepository extends CrudRepository<Seance, Long> {

	public Seance save(Seance Seance);

	public Seance findOne(long id);

	public Set<Seance> findAll();

	public void delete(long id);

}
