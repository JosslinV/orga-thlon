package Database.DeleteDataBase;

import java.sql.Connection;
import java.sql.Statement;

import Database.DatabaseSettings;

public class DeleteBenevole {
	
	public void deleteBenevole(int id) {
		try {
			Connection database = DatabaseSettings.connect();
			
			Statement state = database.createStatement();
			state.executeQuery("DELETE * FROM Orgathlon.Benevole WHERE id_Personne = "+ id +";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}
