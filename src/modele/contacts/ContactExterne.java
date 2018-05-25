package modele.contacts;

public class ContactExterne extends Contact {
	
	private String nomSociete;

	public ContactExterne(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	@Override
	public String toString() {		
		return "Contact externe - Soci�t� : " + this.nomSociete + " nom : " + super.getNom_c() + " pr�nom : " + super.getPrenom_c() ;
	}

}
