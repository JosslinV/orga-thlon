package Database.UpdateDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Materiel;
import modele.Tache;

public class UpdateUtiliser {
	
	private static PreparedStatement preparedStatement = null;

	public void updateDatabase(Tache tache, Materiel oldMateriel, Materiel newMateriel) {
			
		try {
			Connection database = DatabaseSettings.connect();
	
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Utiliser SET id_Materiel WHERE id_Tache =? AND id_Materiel=?");
			preparedStatement.setInt(1, newMateriel.getId_materiel());
			preparedStatement.setInt(2, tache.getId_tache());
			preparedStatement.setInt(3, oldMateriel.getId_materiel());
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
}
