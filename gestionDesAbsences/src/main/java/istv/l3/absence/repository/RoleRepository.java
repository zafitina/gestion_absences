package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role save(Role Role);

	public Role findOne(long id);

	public Set<Role> findAll();

	public void delete(long id);

	public Set<Role> findByRoleUser(int idUser);

}
