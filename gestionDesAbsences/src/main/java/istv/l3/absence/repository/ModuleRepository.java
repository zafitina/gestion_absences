package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Module;

public interface ModuleRepository extends CrudRepository<Module, Long> {

	public Module save(Module module);

	public Module findOne(long id);

	public Set<Module> findAll();

	public void delete(long id);
}
