package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.RoleUser;
import istv.l3.absence.repository.RoleUserRepository;

@Service
public class RoleUserService {

	@Autowired
	private RoleUserRepository roleUserRepository;

	public Set<RoleUser> findAll() {
		return roleUserRepository.findAll();
	}

	public RoleUser save(RoleUser roleUser) {
		return roleUserRepository.save(roleUser);
	}

	public RoleUser findOne(int id) {
		return roleUserRepository.findOne(id);
	}

	public void delete(int id) {
		roleUserRepository.delete(id);
	}
}

