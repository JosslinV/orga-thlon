package Database.UpdateDataBase;

import java.sql.Connection;

import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.contacts.Benevole;

public class UpdateDatabaseBenevole {
	
	private PreparedStatement preparedStatement;
	
	public void updateBenevole(Benevole donnees) {

		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Benevole SET commentaire_benevole=?, civilite_benevole=?, nom_benevole=?, prenom_benevole=?, adresse_benevole=?, codePostal_benevole=?, ville_benevole=?, mail_personnel=?, telephone_benevole=? WHERE id_Personne=?");
			preparedStatement.setString(1, donnees.getCommentaire());
			preparedStatement.setString(2, donnees.getCivilite());
			preparedStatement.setString(3, donnees.getNom_c());
			preparedStatement.setString(4, donnees.getPrenom_c());
			preparedStatement.setString(5, donnees.getAdresse());
			preparedStatement.setString(6, donnees.getCp_c());									//Remplacer par Int
			preparedStatement.setString(7, donnees.getVille_c());
			preparedStatement.setString(8, donnees.getMail_c());
			preparedStatement.setString(9, donnees.getTelephone_c());
			preparedStatement.setInt(10, donnees.getId_personne());
			preparedStatement.executeUpdate();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}
