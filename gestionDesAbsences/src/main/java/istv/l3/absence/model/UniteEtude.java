package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
public class UniteEtude implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9199883701704193321L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@NotNull
	@Column(unique = true)
	@Size(max = 100, min = 3)
	@Getter
	private String codeUE;

	@NotNull
	@Size(max = 100, min = 3)
	@Getter
	private String nom;

	@NotNull
	@OneToMany(mappedBy = "uniteEtude")
	@Getter
	@Setter
	private Set<Module> modules;

	public UniteEtude() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeUE() {
		return codeUE;
	}

	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
