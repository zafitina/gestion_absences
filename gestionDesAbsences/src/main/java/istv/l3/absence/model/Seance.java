package istv.l3.absence.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import istv.l3.absence.enumeration.TypeCours;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Seance implements Serializable {

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
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateSeance;

	@NotNull
	@Getter
	@Setter
	private LocalTime heureDeb;

	@NotNull
	@Getter
	@Setter
	private LocalTime heureFin;

	@OneToOne
	@NotNull
	@Getter
	@Setter
	@JsonIgnore
	private Salle salle;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Getter
	@Setter
	private TypeCours typeCours;

	@NotNull
	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Module module;

	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Admin admin;

	@OneToMany(mappedBy = "seance")
	@Getter
	@Setter
	private Set<Presence> presences;

	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Responsable responsable;

	public Seance() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}

	public LocalTime getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(LocalTime heureDeb) {
		this.heureDeb = heureDeb;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public TypeCours getTypeCours() {
		return typeCours;
	}

	public void setTypeCours(TypeCours typeCours) {
		this.typeCours = typeCours;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<Presence> getPresences() {
		return presences;
	}

	public void setPresences(Set<Presence> presences) {
		this.presences = presences;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
