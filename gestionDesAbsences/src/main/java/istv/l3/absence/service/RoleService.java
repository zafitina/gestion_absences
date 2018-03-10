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

	public Set<Role> findRolesByUser(User user) {
		Set<Role> allRoles = roleRepository.findAll();
		Set<Role> userRoles = new HashSet<>();
		for (Role role : allRoles) {
			if (role.getRoleUser().equals(user.getRoleUser())) {
				userRoles.add(role);
			}
		}
		return userRoles;
	}
}
