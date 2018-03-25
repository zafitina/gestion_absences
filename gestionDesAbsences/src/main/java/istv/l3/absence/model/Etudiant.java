package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Etudiant extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(nullable = true)
	@Getter
	@Setter
	@JsonIgnore
	private Groupe groupe;

	@NotNull
	@Getter
	@Setter
	private boolean reserve;

	@OneToMany(mappedBy = "etudiant")
	@Getter
	@Setter
	@JsonIgnore
	private Set<Presence> presences;

	public Etudiant() {
		super();
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public Set<Presence> getPresences() {
		return presences;
	}

	public void setPresences(Set<Presence> presences) {
		this.presences = presences;
	}
}
