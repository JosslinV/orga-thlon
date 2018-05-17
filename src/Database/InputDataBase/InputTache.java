package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Tache;

public class InputTache{

    private PreparedStatement preparedStatement = null;
    
	public void inputTache(Tache donnees) throws Exception {
		try {
			
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Tache values (default,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setString(2, donnees.getCommentaire());
			preparedStatement.setDate(3, null);								//date
			preparedStatement.setDate(4, null);								//date
			preparedStatement.setDouble(5, donnees.getEtatAvancement());
			preparedStatement.setDate(6, null);								//date
			preparedStatement.setInt(7, donnees.getPriorite());
			preparedStatement.setDate(8, null);								//date
			preparedStatement.setString(9, null);
			preparedStatement.setString(10, null);							//createur ?
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

}
