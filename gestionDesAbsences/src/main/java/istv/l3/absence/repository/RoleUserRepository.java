package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.RoleUser;

public interface RoleUserRepository extends CrudRepository<RoleUser, Long> {

	public Set<RoleUser> findAll();

	public RoleUser save(RoleUser roleUser);

	public RoleUser findOne(long id);

	public void delete(long id);
}
