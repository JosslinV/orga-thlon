package modele;

import java.time.LocalDate;
import java.util.LinkedList;

import modele.Etat.AFaire;
import modele.Etat.Etat;
import modele.contacts.Benevole;

public class Tache {

	private String libelle;
	private String commentaire;
	private LocalDate dateDebut;
	private LocalDate dateEcheance;
	private float etatAvancement;
	private LocalDate dateRappel;
	private String frequenceRappel;
	private int priorite;
	private int tempsRestant;
	private LocalDate dateCreationTache;
	private String etatAvancementGlobal;
	private Etat etat;
	
	private LinkedList<Materiel> materiel;
	private LinkedList<Benevole> benevole;
	
	public Tache(String libelle, LocalDate dateDebut) {
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateCreationTache = dateDebut ;
		this.etat = new AFaire(this);
		
		this.materiel = new LinkedList<Materiel>();
		this.benevole = new LinkedList<Benevole>();
		
	}
	
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public Etat getEtat() {
		return this.etat;
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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(LocalDate dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public double getEtatAvancement() {
		return etatAvancement;
	}

	public void setEtatAvancement(float etatAvancement) {
		this.etatAvancement = etatAvancement;
	}

	public LocalDate getDateRappel() {
		return dateRappel;
	}

	public void setDateRappel(LocalDate dateRappel) {
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

	public LocalDate getDateCreationTache() {
		return dateCreationTache;
	}

	public void setDateCreationTache(LocalDate dateCreationTache) {
		this.dateCreationTache = dateCreationTache;
	}

	public String getEtatAvancementGlobal() {
		return etatAvancementGlobal;
	}

	public void setEtatAvancementGlobal(String etatAvancementGlobal) {
		this.etatAvancementGlobal = etatAvancementGlobal;
	}
	
	public void ajouterMateriel(Materiel item) {
		this.materiel.add(item);
	}
	
	public void ajouterBenevole(Benevole personnel) {
		this.benevole.add(personnel);
	}
	
}
