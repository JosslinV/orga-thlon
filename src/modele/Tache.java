package modele;

import java.time.LocalDate;
import java.util.Date;

public class Tache {

	private String libelle;
	private String commentaire;
	private Date dateDebut;
	private Date dateEcheance;
	private float etatAvancement;
	private Date dateRappel;
	private String frequenceRappel;
	private int priorite;
	private int tempsRestant;
	private Date dateCreationTache;
	private String etatAvancementGlobal;
	
	public Tache(String libelle, Date dateDebut) {
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		//récupère la date du jour (à convertir!)
		this.dateCreationTache = new Date();
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public double getEtatAvancement() {
		return etatAvancement;
	}

	public void setEtatAvancement(float etatAvancement) {
		this.etatAvancement = etatAvancement;
	}

	public Date getDateRappel() {
		return dateRappel;
	}

	public void setDateRappel(Date dateRappel) {
		this.dateRappel = dateRappel;
	}

	public String getFrequenceRappel() {
		return frequenceRappel;
	}

	public void setFrequenceRappel(String frequenceRappel) {
		this.frequenceRappel = frequenceRappel;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public int getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(int tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public Date getDateCreationTache() {
		return dateCreationTache;
	}

	public void setDateCreationTache(Date dateCreationTache) {
		this.dateCreationTache = dateCreationTache;
	}

	public String getEtatAvancementGlobal() {
		return etatAvancementGlobal;
	}

	public void setEtatAvancementGlobal(String etatAvancementGlobal) {
		this.etatAvancementGlobal = etatAvancementGlobal;
	}
	
	
}
