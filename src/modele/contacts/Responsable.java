package modele.contacts;
import modele.Tache;

public class Responsable {

	private Contact contact;
	private Tache tache;
	
	public Responsable(Contact contact, Tache tache) {
		this.contact = contact;
		this.tache = tache;
	}
}
