package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Module implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@NotNull
	@Column(unique = true)
	@Size(max = 100, min = 5)
	@Getter
	private String codeEC;

	@NotNull
	@Size(max = 100, min = 5)
	@Getter
	private String nom;

	@NotNull
	@ManyToOne
	@Getter
	@Setter
	private UniteEtude uniteEtude;

	@OneToMany(mappedBy = "module")
	@Getter
	@Setter
	private Set<Seance> seances;

	@ManyToMany(mappedBy = "modules")
	@Getter
	@Setter
	private Set<Responsable> responsables;

	public Module() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeEC() {
		return codeEC;
	}

	public void setCodeEC(String codeEC) {
		this.codeEC = codeEC;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public UniteEtude getUniteEtude() {
		return uniteEtude;
	}

	public void setUniteEtude(UniteEtude uniteEtude) {
		this.uniteEtude = uniteEtude;
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public Set<Responsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
