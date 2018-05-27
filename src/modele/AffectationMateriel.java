package modele;
import Database.UpdateDataBase.UpdateDatabaseMateriel;

import java.util.ArrayList;
import java.util.List;

import Database.RequestDataBase.RequestMateriel;

public class AffectationMateriel {
	
	private List<Materiel> listeMaterielDisponible;
	private List<Materiel> listeMaterielAssigne;
	private int qteDisponible;
	private int qteAssignee;
	private Materiel materiel;
	
	public AffectationMateriel() {
		this.listeMaterielDisponible = new ArrayList<Materiel>();
		this.listeMaterielAssigne = new ArrayList<Materiel>();
		this.qteAssignee = 0;

		
	}
		
	public ArrayList<Materiel> genererListeMaterielDisponible(){
		RequestMateriel reqMat = new RequestMateriel();
		return reqMat.requestAll();
	}
	
	public Materiel recupererMateriel(int index) {
		if (this.qteDisponible != 0 && this.qteAssignee <= this.qteDisponible)
		 this.listeMaterielDisponible.get(index);
		return materiel; 		
	}
	
	public void modifierQuantite(double qteDisponible, double qteAssignee, Materiel materielDisponible, Materiel materielAssigne) {
		materielDisponible.setStock(materielDisponible.getStock() - qteAssignee); 
		UpdateDatabaseMateriel setMat = new UpdateDatabaseMateriel();
		setMat.updateMateriel(materielDisponible); 
		if ()
			//inputUtiliser
		materielAssigne.setStock(stock);
		//si mat déjà assigné 
		updateUtiliser
		
	}
	
	
	
	
	

}
