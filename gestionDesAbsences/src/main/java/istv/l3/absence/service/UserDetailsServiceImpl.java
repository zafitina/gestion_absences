package istv.l3.absence.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Role;
import istv.l3.absence.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Autowired
	RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String mail) {
		// TODO Auto-generated method stub
		User user = userService.findByMail(mail);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		Set<Role> userRoles = roleService.findRolesByUser(user);
		for (Role role : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getNom()));
		}
		return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(),
				grantedAuthorities);
	}
}
