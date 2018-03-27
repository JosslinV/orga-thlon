package modele.Etat;

import modele.Tache;

public abstract class Etat {
	
	public abstract void suspendre(Tache tache);
	
	public abstract void terminer(Tache tache);
	
	public abstract void effacer(Tache tache);
	
	public abstract void reprendre(Tache tache);
	
	public abstract void supprimer(Tache tache);
	
	public abstract void restaurer(Tache tache);
	
	public abstract void debuter(Tache tache);
}
