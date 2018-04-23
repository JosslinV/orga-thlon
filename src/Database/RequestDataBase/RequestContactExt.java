package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.DatabaseSettings;
import modele.Course;
import modele.contacts.Contact;
import modele.contacts.ContactExterne;

public class RequestContactExt {

	public Contact request(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM contact_ext WHERE id = "+ id +";");
			
			Contact contact = new ContactExterne(result.getString("nom_contact"), result.getString("nom_societe"));
			contact.setCivilite(result.getString("civilite"));
			contact.setCommentaire(result.getString("commentaire_client"));
			contact.setPrenom_c(result.getString("prenom_contact"));
			contact.setAdresse(result.getString("adresse1_contact"));
			contact.setCp_c(result.getString("code_Postal_contact"));
			contact.setVille_c(result.getString("ville_contact"));
			contact.setTelephone_c(result.getString("telephone_contact"));
			contact.setMail_c(result.getString("mail_contact"));
					
			return contact;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
}
