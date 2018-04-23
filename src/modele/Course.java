package modele;

import java.util.Date;

import modele.contacts.Contact;

public class Course {
	
	private String nom_course;
	private String format;
	private Date date_course;
	private String description_course;
	private String lieu_course;
	private int nbParticipants;
	private String parcours;
	private String commentaire_course;
	private float budget;
	private String nom_ville;
	private int cp_ville;
	private String type_epreuve;
	private int duree;
	private boolean agrement;
	private boolean predefini;

	public Course (String nom, boolean predefini) throws Exception {
		this.nom_course = nom;
		this.predefini = predefini;
	}
	
	public String getNom()  {
		return this.nom_course;
	}

	public void setNom(String nom) {
		this.nom_course = nom;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public Date getDateC() {
		return date_course;
	}

	public void setDateC(Date dateC) {
		this.date_course = dateC;
	}

	public String getDescriptionCourse() {
		return description_course;
	}

	public void setDescriptionCourse(String descriptionCourse) {
		this.description_course = descriptionCourse;
	}

	public String getLieu() {
		return lieu_course;
	}

	public void setLieu(String lieu) {
		this.lieu_course = lieu;
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
		return commentaire_course;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire_course = commentaire;
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
