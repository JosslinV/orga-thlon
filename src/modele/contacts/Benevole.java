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
		return " " + super.getNom_c() + " - " + super.getPrenom_c();
	}
}


