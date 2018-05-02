package Database.UpdateDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Database.DatabaseSettings;
import modele.Materiel;

public class UpdateDatabaseMateriel {

	private PreparedStatement preparedStatement;
	
	public void updateMateriel(Materiel donnees) {
		
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Materiel SET libelle_mat=?, stock=?, budget_mat=?, description_mat=? WHERE id_materiel=?");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setDouble(2, donnees.getStock());
			preparedStatement.setDouble(3, donnees.getBudget());
			preparedStatement.setString(4, donnees.getDescription());
			preparedStatement.setInt(5, donnees.getId_materiel());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
	
	
}
