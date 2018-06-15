package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Materiel;

public class InputMateriel {
    private PreparedStatement preparedStatement = null;
    
	public void inputMateriel(Materiel donnees) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Materiel values (default,?,?,?,?)");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setDouble(2, donnees.getStockInitial());
			preparedStatement.setDouble(3, donnees.getBudget());
			preparedStatement.setString(4, donnees.getDescription());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
