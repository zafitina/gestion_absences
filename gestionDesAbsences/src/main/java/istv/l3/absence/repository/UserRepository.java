package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User save(User User);

	public User findOne(long id);

	public Set<User> findAll();

	public User findByMail(String mail);

	public void delete(long id);
}
