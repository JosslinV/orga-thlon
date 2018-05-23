package Database.DeleteDataBase;

import java.sql.Connection;
import java.sql.Statement;

import Database.DatabaseSettings;

public class DeleteTache {
	
	public void deleteTache(int id) {
		try {
			Connection database = DatabaseSettings.connect();
			
			Statement state = database.createStatement();
			state.executeQuery("DELETE * FROM Orgathlon.Tache WHERE id_Tache = "+ id +";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}
