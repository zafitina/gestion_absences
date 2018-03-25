package istv.l3.absence.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import istv.l3.absence.model.Admin;
import istv.l3.absence.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository AdminRepository;

	public Set<Admin> findAll() {
		return AdminRepository.findAll();
	}

	public void save(Admin Admin) {
		AdminRepository.save(Admin);
	}

	public void delete(int id) {
		AdminRepository.delete(id);
	}

	public Admin findOne(int id) {
		return AdminRepository.findOne(id);
	}
}
