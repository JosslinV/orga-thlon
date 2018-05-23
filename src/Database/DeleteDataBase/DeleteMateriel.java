package Database.DeleteDataBase;

import java.sql.Connection;
import java.sql.Statement;

import Database.DatabaseSettings;

public class DeleteMateriel {
	
	public void deleteMateriel(int id) {
		try {
			Connection database = DatabaseSettings.connect();
			
			Statement state = database.createStatement();
			state.executeQuery("DELETE * FROM Orgathlon.Materiel WHERE id_Materiel = "+ id +";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}
