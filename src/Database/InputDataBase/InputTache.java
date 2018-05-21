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
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Tache values (default,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setString(2, donnees.getCommentaire());
			preparedStatement.setObject(3, donnees.getDateDebut());
			preparedStatement.setObject(4, donnees.getDateEcheance());
			preparedStatement.setDouble(5, donnees.getEtatAvancement());
			preparedStatement.setObject(6, donnees.getDateRappel());
			preparedStatement.setInt(7, donnees.getPriorite());
			preparedStatement.setObject(8, donnees.getDateCreationTache());
			preparedStatement.setString(9, donnees.getNomAuteurTache());
			preparedStatement.setInt(10, donnees.getIdResponsable());
			preparedStatement.setBoolean(11, donnees.isPredefinie());
			preparedStatement.setString(12, donnees.getNomResponsableTache());
			preparedStatement.setString(13, donnees.getPrenomResponsableTache());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

}
