package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Batiment;

public interface BatimentRepository extends CrudRepository<Batiment, Long> {

	public Batiment save(Batiment batiment);

	public Set<Batiment> findAll();

	public Batiment findOne(long id);

	public void delete(long id);
}
