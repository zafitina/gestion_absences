package istv.l3.absence.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Role;
import istv.l3.absence.model.User;
import istv.l3.absence.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	// sauvegarder un role
	public void save(Role role) {
		roleRepository.save(role);
	}

	// supprimer un role
	public void delete(int id) {
		roleRepository.delete(id);
	}

	// liste des roles
	public Set<Role> findAll() {
		return roleRepository.findAll();
	}

	// retourner un role
	public Role findOne(int id) {
		return roleRepository.findOne(id);
	}

	// les roles de l'user
	public Set<Role> findRolesByUser(User user) {
		Set<Role> allRoles = roleRepository.findAll();
		Set<Role> userRoles = new HashSet<>();
		for (Role role : allRoles) {
			if (role.getRoleUser().getId() == user.getRoleUser().getId()) {
				userRoles.add(role);
			}
		}
		return userRoles;
	}
}
