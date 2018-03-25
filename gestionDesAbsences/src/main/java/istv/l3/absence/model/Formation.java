package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Formation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@NotNull
	@Getter
	@Setter
	private String titre;

	@NotNull
	@Getter
	@Setter
	private String diplome;

	@NotNull
	@Size(max = 5, min = 1)
	@Getter
	@Setter
	private int annee;

	@NotNull
	@OneToMany(mappedBy = "formation")
	@Getter
	@Setter
	@JsonIgnore
	private Set<Groupe> groupes;

	@NotNull
	@OneToMany(mappedBy = "formation")
	@Getter
	@Setter
	@JsonIgnore
	private Set<Responsable> responsables;

	public Formation() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Set<Responsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}
}
