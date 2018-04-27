package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import Database.DatabaseSettings;
import modele.Tache;

public class InputTache{

    private static PreparedStatement preparedStatement = null;
    
	public static void input(Tache donnees) throws Exception {
		try {
			
			Connection database = DatabaseSettings.connect();

			String requete = "INSERT into Orgathlon.Tache VALUES ("+null+","
														+donnees.getLibelle()+","
														+donnees.getCommentaire()+","
														+new java.sql.Date(donnees.getDateDebut().getTime())+","
														+new java.sql.Date(donnees.getDateEcheance().getTime())+","
														+donnees.getEtatAvancement()+","
														+new java.sql.Date(donnees.getDateRappel().getTime())+","
														+donnees.getPriorite()+","
														+0+","
														+new java.sql.Date(donnees.getDateCreationTache().getTime())+","
														+null+");";

			Statement stmt = database.createStatement() ;
			stmt.executeUpdate(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

}
