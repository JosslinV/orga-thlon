package modele;

public class tache {

	private String libelle;
	private String commentaire;
	private int dateDebut;
	private int dateEcheance;
	private double etatAvancement;
	private int dateRappel;
	private String frequenceRappel;
	private int priorite;
	private int tempsRestant;
	private int dateCreationTache;
	private String etatAvancementGlobal;
	
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

	public int getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(int dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(int dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public double getEtatAvancement() {
		return etatAvancement;
	}

	public void setEtatAvancement(double etatAvancement) {
		this.etatAvancement = etatAvancement;
	}

	public int getDateRappel() {
		return dateRappel;
	}

	public void setDateRappel(int dateRappel) {
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

	public int getDateCreationTache() {
		return dateCreationTache;
	}

	public void setDateCreationTache(int dateCreationTache) {
		this.dateCreationTache = dateCreationTache;
	}

	public String getEtatAvancementGlobal() {
		return etatAvancementGlobal;
	}

	public void setEtatAvancementGlobal(String etatAvancementGlobal) {
		this.etatAvancementGlobal = etatAvancementGlobal;
	}
	
	
}
