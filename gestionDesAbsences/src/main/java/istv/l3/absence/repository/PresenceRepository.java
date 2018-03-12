package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Presence;

public interface PresenceRepository extends CrudRepository<Presence, Long> {

	public Set<Presence> findAll();

	public Presence findOne(long id);

	public Presence save(Presence presence);

	public void delete(long id);
}
