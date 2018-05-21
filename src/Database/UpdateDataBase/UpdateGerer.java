package Database.UpdateDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Tache;
import modele.contacts.Benevole;

public class UpdateGerer {
	
	private static PreparedStatement preparedStatement = null;

	public void updateDatabase(Tache tache, Benevole oldBenevole, Benevole newBenevole, String poste) {
			
		try {
			Connection database = DatabaseSettings.connect();
	
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Gerer SET id_Contact=?, poste=? WHERE id_Course =? AND id_Contact=?");
			preparedStatement.setInt(1, newBenevole.getId_personne());
			preparedStatement.setString(2, poste);
			preparedStatement.setInt(2, tache.getId_tache());
			preparedStatement.setInt(3, oldBenevole.getId_personne());
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
}
