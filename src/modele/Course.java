package modele;

import java.util.Date;

import modele.contacts.Contact;

public class Course {
	
	private String nom;
	private String format;
	private Date dateC;
	private String descriptionCourse;
	private String lieu;
	private int nbParticipants;
	private String parcours;
	private String commentaire;
	private float budget;
	private String nom_ville;
	private int cp_ville;
	private String type_epreuve;
	private int duree;
	private boolean agrement;
	private boolean predefini;
	
	public Course(String nom, boolean predefini) {
		this.nom = nom;
		this.predefini = predefini;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}

	public String getDescriptionCourse() {
		return descriptionCourse;
	}

	public void setDescriptionCourse(String descriptionCourse) {
		this.descriptionCourse = descriptionCourse;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public String getParcours() {
		return parcours;
	}

	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public int getCp_ville() {
		return cp_ville;
	}

	public void setCp_ville(int cp_ville) {
		this.cp_ville = cp_ville;
	}

	public String getType_epreuve() {
		return type_epreuve;
	}

	public void setType_epreuve(String type_epreuve) {
		this.type_epreuve = type_epreuve;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isAgrement() {
		return agrement;
	}

	public void setAgrement(boolean agrement) {
		this.agrement = agrement;
	}

	public boolean isPredefini() {
		return predefini;
	}

	public void setPredefini(boolean predefini) {
		this.predefini = predefini;
	}
	
	public void affecter(Tache t, Contact c) {
		
	}
	
}
