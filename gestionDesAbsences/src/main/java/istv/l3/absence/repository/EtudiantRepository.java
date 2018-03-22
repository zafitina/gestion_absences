package istv.l3.absence.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import istv.l3.absence.model.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {

	public Etudiant save(Etudiant Etudiant);

	public Etudiant findOne(long id);

	public Set<Etudiant> findAll();

	public Etudiant findByMail(String mail);

	public void delete(long id);
}
