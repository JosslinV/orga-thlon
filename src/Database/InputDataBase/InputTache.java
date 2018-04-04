package Database.InputDataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Tache;

public class InputTache{

    private static PreparedStatement preparedStatement = null;
    
	public static void input(Tache donnees) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Tache values (default,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setString(2, donnees.getCommentaire());
			preparedStatement.setDate(3,new java.sql.Date(donnees.getDateDebut().getTime()));
			preparedStatement.setDate(4,new java.sql.Date(donnees.getDateEcheance().getTime()));
			preparedStatement.setDouble(5, donnees.getEtatAvancement());
			preparedStatement.setDate(6,new java.sql.Date(donnees.getDateRappel().getTime()));
			preparedStatement.setInt(7, donnees.getPriorite());
			preparedStatement.setInt(8, 0);									//Remplacer par Boolean
			preparedStatement.setDate(9,new java.sql.Date(donnees.getDateCreationTache().getTime()));
			preparedStatement.setString(10, null);							//Créer nom_créateur
			preparedStatement.setInt(11, 0);								//Créer id_personne
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

}
