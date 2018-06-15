package modele.contacts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Carnet_Adresses {
	private Map <String, Contact> annuaire;
	private String cle;
	private Contact contact;
	
	public Carnet_Adresses() {
		this.annuaire = new TreeMap <String, Contact>();
		this.cle = this.contact.toString();
	}

	public void ajouter(Contact contact) {
		//la clé est de la forme "nom - prenom"
		this.annuaire.put(cle, contact); 
	}
	
	public void supprimer(Contact contact) {
		this.annuaire.remove(cle);
	}		
	
	public Contact trouverUnContact(String nom, String prenom) {
		return null;
		
	}
	
	public Collection<Contact> extraireListeDesContacts(){
		Collection<Contact> listeDesContacts = this.annuaire.values();
		listeDesContacts = new ArrayList<Contact>();
		return listeDesContacts;
	}
	
	public ArrayList<Benevole> extraireListeDesBenevoles(Collection<Contact> listeDesContacts){		
		ArrayList<Benevole> listedeBenevoles = new ArrayList<Benevole>();
		for (Contact contact : listeDesContacts) {
			if (contact instanceof Benevole) 
				listedeBenevoles.add((Benevole) contact);	
		}
		return listedeBenevoles;
	}

}


