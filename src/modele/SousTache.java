package modele;

public class SousTache extends Tache {

	private String titre;
	private String description;
	private float partAvancement;
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPartAvancement() {
		return partAvancement;
	}

	public void setPartAvancement(float partAvancement) {
		this.partAvancement = partAvancement;
	}
	
	public void contribuerAvancement() {
		
	}
	
}
