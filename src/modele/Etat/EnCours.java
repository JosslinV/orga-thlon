package modele.Etat;

import modele.Tache;

public class EnCours extends Etat {

	public EnCours(Tache tache) {
		super(tache);
	}

	@Override
	public void suspendre() {
		this.tache.setEtat(new Suspendu(this.tache));
	}

	@Override
	public void terminer() {
		this.tache.setEtat(new Termine(this.tache));
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
		return "Etat: En cours";
	}

}
