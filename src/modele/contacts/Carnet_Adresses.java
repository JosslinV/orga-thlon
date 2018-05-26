package modele.contacts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
		this.annuaire.put(cle, contact); //la clé est de la forme "nom - prenom"
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
	/*
	public ArrayList<Benevole> extraireListeDesContactsExternes(){
		

	}
	*/




//Si gestion des homonymes.........................
/*
public class Carnet_Adresses {
	private Map <String, Set <Contact>> annuaire;
	
	public Carnet_Adresses() {
		this.annuaire = new TreeMap <String, Set<Contact>>();
	}

	public void ajouter(Contact contact) {
		String cle = contact.toString();
		Set<Contact> valeurSet = this.annuaire.get(cle);
		if (valeurSet == null) {
			valeurSet = new HashSet<Contact>();
			this.annuaire.put(cle, valeurSet);
		}
		valeurSet.add(contact);			
	}
	
	public void supprimer(Contact contact) {
		String cle = contact.toString();
		this.annuaire.remove(cle);
	}		
	
	public Contact trouverUnContact(String nom, String prenom) {
		return null;
		
	}
	
	public Collection<Set<Contact>> extraireListeDesContacts(){
		Collection<Set<Contact>> listeDesContacts = this.annuaire.values();
		listeDesContacts = new ArrayList<Set<Contact>>();
		return listeDesContacts;
	}
	
	public ArrayList<Benevole> extraireListeDesBenevoles(Collection<Set<Contact>> listeDesContacts){
		
		Collection<Set<Benevole>> listedeBenevoles = new ArrayList<Set<Benevole>>();
	for (Contact contact : carnet_Adresse) {
		if (contact instanceof Benevole) {
			this.listedeBenevoles.add((Benevole) contact);
		}
	}
	}

	public ArrayList<Benevole> extraireListeDesContactsExternes()

	}
*/
}


