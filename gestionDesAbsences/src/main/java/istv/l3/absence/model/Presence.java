package istv.l3.absence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Presence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -816759393848522735L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private int id;

	@Getter
	@Setter
	@NotNull
	private boolean present = true;

	@ManyToOne
	@Getter
	@Setter
	private Etudiant etudiant;

	@ManyToOne
	@Getter
	@Setter
	private Seance seance;

	public Presence() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}
}
