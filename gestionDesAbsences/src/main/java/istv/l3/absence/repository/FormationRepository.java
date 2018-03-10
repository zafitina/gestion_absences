package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Formation;

public interface FormationRepository extends CrudRepository<Formation, Long> {

	public Formation save(Formation formation);

	public Formation findOne(long id);

	public Set<Formation> findAll();

	public void delete(long id);
}
