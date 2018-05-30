package modele;
import Database.UpdateDataBase.UpdateDatabaseMateriel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Database.RequestDataBase.RequestMateriel;

public class AffectationMateriel {
	
	private List<Materiel> listeMaterielDisponible;
	private List<Materiel> listeMaterielAssigne;
	private int qteDisponible;
	private int quantiteAssignee;
	private Materiel materielvide;
	private HashMap<String,Float> correspondance ;
	
	public AffectationMateriel() {
		this.listeMaterielDisponible = new ArrayList<Materiel>();
		this.listeMaterielAssigne = new ArrayList<Materiel>();
		this.quantiteAssignee = 0;
		this.correspondance = new HashMap<>();

		
	}
		
	public ArrayList<Materiel> genererListeMaterielDisponible(){
		RequestMateriel reqMat = new RequestMateriel();
		return reqMat.requestAll();
	}
	
	public Materiel recupererMateriel(int index) throws IllegalArgumentException{
		if (this.qteDisponible != 0 && this.quantiteAssignee <= this.qteDisponible) {
			return this.listeMaterielDisponible.get(index);
		}else { 
			return this.materielvide ;
		}
	}
	
	/*public void modifierQuantite(double qteDisponible, double qteAssignee, Materiel materielDisponible, Materiel materielAssigne) {
		materielDisponible.setStock(materielDisponible.getStock() - qteAssignee); 
		UpdateDatabaseMateriel setMat = new UpdateDatabaseMateriel();
		setMat.updateMateriel(materielDisponible); 
		if ()
			//inputUtiliser
		materielAssigne.setStock(stock);
		//si mat déjà assigné 
		updateUtiliser
		
	}
	*/
	
	public String constituerString(Tache t, Materiel m) {
		return ""+ t.getId_tache() + "_" + m.getId_materiel() ;
	}

	public int retrouverIdTache(String s) {
		int n=0 ;
		for (int i = 0 ; i<s.length(); i++) {
			if (s.charAt(i)=='_') {
				n=i ;
			}
		}
		
		return Integer.parseInt(s.substring(0, n-1)) ;
	}
	
	public int retrouverIdMateriel(String s) {
		
		int n=0 ;
		for (int i = 0 ; i<s.length(); i++) {
			if (s.charAt(i)=='_') {
				n=i ;
			}
		}
		
		return Integer.parseInt(s.substring(n+1, s.length())) ;
	}
	
	public void AffecterMateriel (Tache t, Materiel m, float quantiteAffectee ) {
		
		if(quantiteAffectee<m.getStock()) {
			
			String s = constituerString(t,m) ;
		
		
			if (!this.correspondance.containsKey(s)) {
			
				this.correspondance.put(s, quantiteAffectee) ;
			}
			else {
				this.correspondance.put(s, quantiteAffectee + this.correspondance.get(s)) ; //put remplace la valeur si la clé existe
			}
		
		
		}
	}
	
	

	public void DesaffacterMateriel (Tache t, Materiel m, float quantiteDesaffectee) {
		
		String s = constituerString(t,m) ;
		
		if (quantiteDesaffectee<this.correspondance.get(s) && this.correspondance.containsKey(s)) {
			
			this.correspondance.put(s, this.correspondance.get(s)- quantiteDesaffectee) ;
			
		}
	}
	
}
