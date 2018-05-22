package Database.DeleteDataBase;

import java.sql.Connection;
import java.sql.Statement;

import Database.DatabaseSettings;

public class DeleteContactExterne {
	
	public void deleteContactExterne(int id) {
		try {
			Connection database = DatabaseSettings.connect();
			
			Statement state = database.createStatement();
			state.executeQuery("DELETE * FROM Orgathlon.ContactExt WHERE id_Personne = "+ id +";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}
