package modele;

public class SousTache {

	private String titre;
	private String description;
	private float partAvancement;
	private int id_Tache;
	
	public SousTache(String titre, float partAvancement, int id_Tache) {
		this.titre = titre;
		this.partAvancement = partAvancement;
		this.setId_Tache(id_Tache);
	}
	
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

	public int getId_Tache() {
		return id_Tache;
	}

	public void setId_Tache(int id_Tache) {
		this.id_Tache = id_Tache;
	}
	
}
