package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Responsable extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Getter
	@Setter
	private Boolean reserve;

	@OneToMany(mappedBy = "responsable")
	@Getter
	@Setter
	@JsonIgnore
	private Set<Demande> lesDemandes;

	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Formation formation;

	@OneToMany(mappedBy = "responsable")
	@Getter
	@Setter
	@JsonIgnore
	private Set<Seance> seances;

	public Responsable() {
		super();
	}

	public Boolean getReserve() {
		return reserve;
	}

	public void setReserve(Boolean reserve) {
		this.reserve = reserve;
	}

	public Set<Demande> getLesDemandes() {
		return lesDemandes;
	}

	public void setLesDemandes(Set<Demande> lesDemandes) {
		this.lesDemandes = lesDemandes;
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

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}
}
