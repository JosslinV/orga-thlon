package Database.RequestDataBase;

import java.sql.Connection;
import modele.AffectationMateriel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Database.DatabaseSettings;
import modele.Materiel;
import modele.Tache;

public class RequestUtiliser {
	
	private List<Tache> list;
	
	public  int requestUtiliser(Materiel mat, Tache tache) { //il faut à la fois une tache et un mat
		int n=0 ;
		try {
			Connection database = DatabaseSettings.connect();
			Statement state = database.createStatement();
			
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Utiliser WHERE id_Materiel = "+ mat.getId_materiel() 
																					+"AND id_tache = "+ tache.getId_tache() + ";");
			
			
			/*
			this.list = new LinkedList<Tache>();
			
			while(result.next()) {
				RequestTache reqTac = new RequestTache();
				Tache tac = reqTac.requestTache(result.getInt("id_Tache"));
				
				this.list.add(tac);	
			}
			
			return this.list;
			*/
			
			while(result.next()) {
				//pour s'en servir
				//AffectationMateriel am = new AffectationMateriel() ;
				//am.AffecterMateriel(tache, mat, DB.requestUtiliser(mat, tache)")
				n = result.getInt("quantiteAssignee")  ;
				
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return n ;
	}
}
