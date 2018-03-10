package istv.l3.absence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.User;
import istv.l3.absence.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findByMail(String mail) {
		for (User user : userRepository.findAll()) {
			if (user.getMail().equals(mail)) {
				return user;
			}
		}
		return null;
	}
}
