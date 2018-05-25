package modele.contacts;

public class Benevole extends Contact {

	private String role;
	
	public Benevole(String nom, String prenom) {
		super(nom, prenom);
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {		
		return "Contact bénévole - nom : " + super.getNom_c() + " prénom : " + super.getPrenom_c() + " rôle : " + this.getRole();
	}
}


