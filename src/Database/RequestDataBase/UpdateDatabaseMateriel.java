package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import modele.Materiel;
import Database.DatabaseSettings;

public class UpdateDatabaseMateriel {


	public void updateDatabaseMateriel (Materiel donnees) throws Exception {
	//(int id_Materiel, String libelle, float stock, float budget, String Description_mat  ) throws Exception {
		
		try {
			Connection database = DatabaseSettings.connect();

			String requete = "UPDATE orgathlon.materiel" + " SET libelle='" + donnees.getLibelle()
														+"'AND stock=" + donnees.getStock()
														+"AND budget=" + donnees.getBudget()
														+"AND Description_mat='" + donnees.getDescription()										
														+"'WHERE id_Materiel = " + donnees.getId_matériel() ;
			
			Statement stmt = database.createStatement() ;
			stmt.executeQuery(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
	
	
}
