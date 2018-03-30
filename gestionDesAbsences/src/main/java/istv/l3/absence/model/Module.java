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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private UniteEtude uniteEtude;

	@OneToMany(mappedBy = "module")
	@Getter
	@Setter
	@JsonIgnore
	private Set<Seance> seances;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
