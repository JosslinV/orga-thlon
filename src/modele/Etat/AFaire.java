package modele.Etat;

import modele.Tache;

public class AFaire extends Etat {

	public AFaire(Tache tache) {
		super(tache);
	}

	@Override
	public void suspendre() {
		this.tache.setEtat(new Suspendu(this.tache));
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
		this.tache.setEtat(new EnCours(this.tache));
	}
	
	@Override
	public String toString() {
		return "Etat: A faire";
	}

}
