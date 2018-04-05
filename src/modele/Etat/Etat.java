package modele.Etat;

import modele.Tache;

public abstract class Etat {
	
	protected Tache tache;
	
	public Etat(Tache tache) {
		this.tache = tache;
	}
	
	public abstract void suspendre();
	
	public abstract void terminer();
	
	public abstract void reprendre();
	
	public abstract void supprimer();
	
	public abstract void restaurer();
	
	public abstract void debuter();
}
