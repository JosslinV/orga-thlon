package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Materiel;
import modele.Tache;

public class InputUtiliser {

    private PreparedStatement preparedStatement = null;
    
	public void inputUtiliser(Materiel materiel, Tache tache, float quantiteAssignee) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Utiliser values (?,?,?)");
			preparedStatement.setInt(1, materiel.getId_materiel());
			preparedStatement.setInt(2, tache.getId_tache());
			preparedStatement.setFloat(3, quantiteAssignee);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
