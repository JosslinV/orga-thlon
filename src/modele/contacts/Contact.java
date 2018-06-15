package modele.contacts;

public abstract class Contact {


	private String commentaire;
	private String civilite;
	private String nom_c;
	private String prenom_c;
	private String adresse;
	private String cp_c;
	private String ville_c;
	private String telephone_c;
	private String mail_c;
	private int id_personne ;
	
	public Contact (String nom, String prenom) {
		this.nom_c = nom;
		this.prenom_c = prenom;
	}
	
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}

	public int getId_personne() {
		return id_personne;
	}

	
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom_c() {
		return nom_c;
	}

	public void setNom_c(String nom_c) {
		this.nom_c = nom_c;
	}

	public String getPrenom_c() {
		return prenom_c;
	}

	public void setPrenom_c(String prenom_c) {
		this.prenom_c = prenom_c;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp_c() {
		return cp_c;
	}

	public void setCp_c(String cp_c) {
		this.cp_c = cp_c;
	}

	public String getVille_c() {
		return ville_c;
	}

	public void setVille_c(String ville_c) {
		this.ville_c = ville_c;
	}

	public String getTelephone_c() {
		return telephone_c;
	}

	public void setTelephone_c(String telephone_c) {
		this.telephone_c = telephone_c;
	}

	public String getMail_c() {
		return mail_c;
	}

	public void setMail_c(String mail_c) {
		this.mail_c = mail_c;
	}
	
	public abstract String toString(); 

}
	
	

