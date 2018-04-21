package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import Database.DatabaseSettings;

public class UpdateDatabaseMateriel {


	public void updateDatabaseTache (int id, String libelle, float stock, float budget, String Description_mat  ) throws Exception {
		
		try {
			Connection database = DatabaseSettings.connect();

			String requete = "UPDATE orgathlon.course" + " SET libelle='" + libelle
														+"'AND stock=" + stock
														+"AND budget=" + budget
														+"AND Description_mat='" + Description_mat											
														+"'WHERE id_Course = " + id ;
			
			Statement stmt = database.createStatement() ;
			stmt.executeQuery(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
	
	
}
