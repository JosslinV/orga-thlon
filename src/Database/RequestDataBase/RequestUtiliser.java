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
	
	private List<Materiel> list;
	
	public  List<Materiel> requestUtiliser(Tache tache) {
		try {
			Connection database = DatabaseSettings.connect();
			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Utiliser WHERE id_tache = "+ tache.getId_tache() + ";");
			
			
			this.list = new LinkedList<Materiel>();
			
			while(result.next()) {
				RequestMateriel reqMat = new RequestMateriel();
				Materiel mat = reqMat.requestMateriel(result.getInt("id_Materiel"));
				
				this.list.add(mat);
			}
			return this.list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null ;
	}
}
