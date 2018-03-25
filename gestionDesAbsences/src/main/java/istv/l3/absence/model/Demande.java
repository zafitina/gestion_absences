package istv.l3.absence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import istv.l3.absence.enumeration.EtatDemande;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Demande implements Serializable {

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
	private String sujet;

	@NotNull
	@Getter
	@Setter
	private String description;

	@NotNull
	@Getter
	@Setter
	private Date dateDemande;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Getter
	@Setter
	private EtatDemande etatDemande;

	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Responsable responsable;

	@ManyToOne
	@Getter
	@Setter
	@JsonIgnore
	private Admin admin;

	public Demande() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public EtatDemande getEtatDemande() {
		return etatDemande;
	}

	public void setEtatDemande(EtatDemande etatDemande) {
		this.etatDemande = etatDemande;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
