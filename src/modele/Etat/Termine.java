package modele.Etat;

import modele.Tache;

public class Termine extends Etat {

	public Termine(Tache tache) {
		super(tache);
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
		this.tache.setEtat(new Supprime(this.tache, this.tache.getEtat()));
	}

	@Override
	public void restaurer() {
	}

	@Override
	public void debuter() {
	}
	
	@Override
	public String toString() {
		return "Etat: Terminée";
	}

}
