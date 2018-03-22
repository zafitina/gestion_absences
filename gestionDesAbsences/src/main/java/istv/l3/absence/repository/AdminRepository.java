package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {

	public Admin save(Admin Admin);

	public Admin findOne(long id);

	public Set<Admin> findAll();

	public Admin findByMail(String mail);

	public void delete(long id);
}
