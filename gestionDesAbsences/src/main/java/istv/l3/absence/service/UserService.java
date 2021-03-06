package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Admin;
import istv.l3.absence.model.Etudiant;
import istv.l3.absence.model.Responsable;
import istv.l3.absence.model.User;
import istv.l3.absence.repository.AdminRepository;
import istv.l3.absence.repository.EtudiantRepository;
import istv.l3.absence.repository.ResponsableRepository;
import istv.l3.absence.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ResponsableRepository responsableRepository;
	@Autowired
	private AdminRepository adminRepository;

	// recupérer l'utiisateur connecté
	public User getLoggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return findByEmail(username);
	}

	// rechercher un utilisateur par son mail
	public User findByEmail(String email) {
		User user = null;
		if (email.contains("etu")) {
			for (Etudiant e : etudiantRepository.findAll()) {
				if (e.getMail().equals(email)) {
					user = e;
				}
			}
		} else if (email.contains("prof")) {
			for (Responsable r : responsableRepository.findAll()) {
				if (r.getMail().equals(email)) {
					user = r;
				}
			}
		} else {
			for (Admin a : adminRepository.findAll()) {
				if (a.getMail().equals(email)) {
					user = a;
				}
			}
		}
		return user;
	}

	public Set<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public User findByMail(String mail) {
		for (User user : userRepository.findAll()) {
			if (user.getMail().equals(mail)) {
				return user;
			}
		}
		return null;
	}
}
