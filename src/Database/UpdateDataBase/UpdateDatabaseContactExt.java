package Database.UpdateDataBase;

import java.sql.Connection;

import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.contacts.ContactExterne;

public class UpdateDatabaseContactExt {
	
	private PreparedStatement preparedStatement;
	
	public void updateContactExt(ContactExterne donnees) {

		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Contact_Ext SET civilite=?, commentaire_contact=?, nom_societe=?, nom_contact=?, prenom_contact=?, adresse1_contact=?, code_Postal_contact=?, ville_contact=?, telephone_contact=?, mail_contact=? WHERE id_Contact=?");
			preparedStatement.setString(1, donnees.getCivilite());
			preparedStatement.setString(2, donnees.getCommentaire());
			preparedStatement.setString(3, ((ContactExterne)donnees).getNomSociete());
			preparedStatement.setString(4, donnees.getNom_c());
			preparedStatement.setString(5, donnees.getPrenom_c());
			preparedStatement.setString(6, donnees.getAdresse());
			preparedStatement.setString(7, donnees.getCp_c());									//Remplacer par Int
			preparedStatement.setString(8, donnees.getMail_c());
			preparedStatement.setString(9, donnees.getVille_c());
			preparedStatement.setString(10, donnees.getTelephone_c());
			preparedStatement.setInt(11, donnees.getId_personne());
			preparedStatement.executeUpdate();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}

