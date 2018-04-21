package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import Database.DatabaseSettings;

public class UpdateDatabaseMateriel {


	public void updateDatabaseMateriel (int id_Materiel, String libelle, float stock, float budget, String Description_mat  ) throws Exception {
		
		try {
			Connection database = DatabaseSettings.connect();

			String requete = "UPDATE orgathlon.materiel" + " SET libelle='" + libelle
														+"'AND stock=" + stock
														+"AND budget=" + budget
														+"AND Description_mat='" + Description_mat											
														+"'WHERE id_Materiel = " + id_Materiel ;
			
			Statement stmt = database.createStatement() ;
			stmt.executeQuery(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
	
	
}
