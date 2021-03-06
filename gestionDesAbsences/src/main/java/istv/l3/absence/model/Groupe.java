package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Groupe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@OneToMany(mappedBy = "groupe")
	@NotNull
	@Getter
	@Setter
	@JsonIgnore
	private Set<Etudiant> etudiants;

	@Getter
	@Setter
	private int td;

	@Getter
	@Setter
	private int tp;

	@Getter
	@Setter
	private String nom;

	@NotNull
	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Formation formation;

	public Groupe() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public int getTd() {
		return td;
	}

	public void setTd(int td) {
		this.td = td;
	}

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
