package modele.contacts;
import modele.Tache;

public class Responsable {

	private Contact contact;
	private Tache tache;
	
	public Responsable(Contact contact, Tache tache) {
		this.contact = contact;
		this.tache = tache;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}
}
