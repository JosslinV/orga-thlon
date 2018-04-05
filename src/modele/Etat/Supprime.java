package modele.Etat;

import modele.Tache;

public class Supprime extends Etat{

	private Etat etat;
	
	public Supprime(Tache tache, Etat etat) {
		super(tache);
		this.etat = etat;
	}

	@Override
	public void suspendre() {
	}

	@Override
	public void terminer() {
	}

	@Override
	public void reprendre() {	
	}

	@Override
	public void supprimer() {
	}

	@Override
	public void restaurer() {
		this.tache.setEtat(etat);
	}

	@Override
	public void debuter() {
	}
	
	public void effacer() {	
	}
	
	@Override
	public String toString() {
		return "Etat: Supprim�e";
	}

}
