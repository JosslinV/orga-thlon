package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.DatabaseSettings;
import modele.contacts.Benevole;
import modele.contacts.Contact;
public class RequestBenevole {

	public Contact request(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM contact_ext WHERE id = "+ id +";");
			
			if(result.next()) {
				Contact contact = new Benevole(result.getString("nom_benevole"));
				
				contact.setCivilite(result.getString("civilite"));
				contact.setCommentaire(result.getString("commentaire_benevole"));
				contact.setPrenom_c(result.getString("prenom_benevole"));
				contact.setAdresse(result.getString("adresse_benevole"));
				contact.setCp_c(result.getString("codePostal_benevole"));
				contact.setVille_c(result.getString("ville_benevole"));
				contact.setTelephone_c(result.getString("telephone_benevole"));
				contact.setMail_c(result.getString("mail_personnel"));
						
				return contact;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
}
