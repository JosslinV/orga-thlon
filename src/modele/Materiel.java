package modele;

public class Materiel {
	
	private String libelle;
	private double stockInitial;
	private double stockFinal;
	private double budget;
	private String description;
	private int id_materiel ;

	public Materiel(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getStockInitial() {
		return stockInitial;
	}

	public void setStockInitial(double stockInitial) {
		this.stockInitial = stockInitial;
	}

	public double getStockFinal() {
		return stockFinal;
	}

	public void setStockFinal(double stockFinal) {
		this.stockFinal = stockFinal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId_materiel() {
		return id_materiel;
	}

	public void setId_materiel(int id_materiel) {
		this.id_materiel = id_materiel;
	}
	
	public String toString() {
		return " " + this.getLibelle() + " (Qté : " + this.getStockInitial() + ")"; 
	}
}
