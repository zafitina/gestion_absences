package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Demande;

public interface DemandeRepository extends CrudRepository<Demande, Long> {

	public Demande save(Demande demande);

	public Demande findOne(long id);

	public Set<Demande> findAll();

	public void delete(long id);
}
