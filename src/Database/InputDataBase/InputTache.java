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
			preparedStatement.setDate(3,(Date) donnees.getDateDebut());
			preparedStatement.setDate(4,(Date) donnees.getDateEcheance());
			preparedStatement.setDouble(5, donnees.getEtatAvancement());
			preparedStatement.setDate(6,(Date) donnees.getDateRappel());
			preparedStatement.setInt(7, donnees.getPriorite());
			preparedStatement.setInt(8, 0);									//Remplacer par Boolean
			preparedStatement.setDate(9,(Date) donnees.getDateCreationTache());
			preparedStatement.setString(10, null);							//Cr�er nom_cr�ateur
			preparedStatement.setInt(11, 0);								//Cr�er id_personne
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

}
