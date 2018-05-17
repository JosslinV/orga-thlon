package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Tache;
import modele.contacts.Benevole;

public class InputGérer {
	
	private PreparedStatement preparedStatement;

	public void inputGérer(Benevole benevole, Tache tache, String poste) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Gérer values (?,?,?)");
			preparedStatement.setInt(1, benevole.getId_personne());
			preparedStatement.setInt(2, tache.getId_tache());
			preparedStatement.setString(3, poste);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
