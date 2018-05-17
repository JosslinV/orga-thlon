package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.contacts.*;

public class InputContact {

    private PreparedStatement preparedStatement = null;
    
	public void inputContact(Contact donnees) throws Exception {
		
		if(donnees instanceof ContactExterne) {
			try {
				Connection database = DatabaseSettings.connect();
				
				preparedStatement = database.prepareStatement("insert into  Orgathlon.Contact_Ext values (default,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, donnees.getCivilite());
				preparedStatement.setString(2, donnees.getCommentaire());
				preparedStatement.setString(3, ((ContactExterne) donnees).getNomSociete());
				preparedStatement.setString(4, donnees.getNom_c());
				preparedStatement.setString(5, donnees.getPrenom_c());
				preparedStatement.setString(6, donnees.getAdresse());
				preparedStatement.setString(7, donnees.getCp_c());
				preparedStatement.setString(8, donnees.getVille_c());
				preparedStatement.setString(9, donnees.getTelephone_c());
				preparedStatement.setString(10, donnees.getMail_c());
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				throw e;
			} finally {
				DatabaseSettings.close();
			}
			
		}else if(donnees instanceof Benevole) {
			try {
				Connection database = DatabaseSettings.connect();
				
				preparedStatement = database.prepareStatement("insert into  Orgathlon.Benevole values (default,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, donnees.getCommentaire());
				preparedStatement.setString(2, donnees.getCivilite());
				preparedStatement.setString(3, donnees.getNom_c());
				preparedStatement.setString(4, donnees.getPrenom_c());
				preparedStatement.setString(5, donnees.getAdresse());
				preparedStatement.setString(6, donnees.getCp_c());
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
