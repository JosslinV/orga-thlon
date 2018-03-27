package modele.contacts;

public class ContactExterne extends Contact {
	
	private String nomSociete;

	public ContactExterne(String nom, String nomSociete) {
		super(nom);
		this.nomSociete = nomSociete;
	}
	
	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

}
