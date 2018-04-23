package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.contacts.*;

public class InputContact {

    private static PreparedStatement preparedStatement = null;
    
	public static void input(Contact donnees) throws Exception {
		
		if(donnees instanceof ContactExterne) {
			try {
				Connection database = DatabaseSettings.connect();
				
				preparedStatement = database.prepareStatement("insert into  Orgathlon.Contact_Ext values (default,?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, "");
				preparedStatement.setString(2, donnees.getCivilite());
				preparedStatement.setString(3, donnees.getCommentaire());
				preparedStatement.setString(4, ((ContactExterne) donnees).getNomSociete());
				preparedStatement.setString(5, donnees.getNom_c());
				preparedStatement.setString(6, donnees.getPrenom_c());
				preparedStatement.setString(7, donnees.getAdresse());
				preparedStatement.setString(8, donnees.getCp_c());									//Remplacer par Int
				preparedStatement.setString(9, donnees.getVille_c());
				preparedStatement.setString(10, donnees.getTelephone_c());
				preparedStatement.setString(11, donnees.getMail_c());
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				throw e;
			} finally {
				DatabaseSettings.close();
			}
			
		}else if(donnees instanceof Benevole) {
			try {
				Connection database = DatabaseSettings.connect();
				
				preparedStatement = database.prepareStatement("insert into  Orgathlon.Tache values (default,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, donnees.getCommentaire());
				preparedStatement.setString(2, donnees.getCivilite());
				preparedStatement.setString(3, donnees.getNom_c());
				preparedStatement.setString(4, donnees.getPrenom_c());
				preparedStatement.setString(5, donnees.getAdresse());
				preparedStatement.setString(6, donnees.getCp_c());									//Remplacer par Int
				preparedStatement.setString(7, donnees.getVille_c());
				preparedStatement.setString(8, donnees.getMail_c());
				preparedStatement.setString(9, donnees.getTelephone_c());
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				throw e;
			} finally {
				DatabaseSettings.close();
			}
		}
	}
}
