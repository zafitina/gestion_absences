package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Responsable;

public interface ResponsableRepository extends CrudRepository<Responsable, Long> {

	public Responsable save(Responsable Responsable);

	public Responsable findOne(long id);

	public Set<Responsable> findAll();

	public Responsable findByMail(String mail);

	public void delete(long id);
}
