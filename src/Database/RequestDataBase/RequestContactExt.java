package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DatabaseSettings;
import modele.contacts.Contact;
import modele.contacts.ContactExterne;

public class RequestContactExt {
	// Obtenir un contact externe selon son ID
	public ContactExterne requestContactExt(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Contact_Ext WHERE id_Contact = "+ id +";");
			
			if(result.next()) {
				ContactExterne contact = new ContactExterne(result.getString("nom_contact"), result.getString("nom_societe"));
				
				contact.setId_personne(result.getInt("id_Contact"));
				contact.setCivilite(result.getString("civilite"));
				contact.setCommentaire(result.getString("commentaire_contact"));
				contact.setPrenom_c(result.getString("prenom_contact"));
				contact.setAdresse(result.getString("adresse1_contact"));
				contact.setCp_c(result.getString("code_Postal_contact"));
				contact.setVille_c(result.getString("ville_contact"));
				contact.setTelephone_c(result.getString("telephone_contact"));
				contact.setMail_c(result.getString("mail_contact"));
						
				return contact;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
	
	// Obtenir la liste complète de contact externe
	public ArrayList<ContactExterne> requestAll() throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			
			ResultSet result = state.executeQuery("SELECT * FROM Contact_Ext WHERE id_Contact;");
			ArrayList<ContactExterne> list = new ArrayList<ContactExterne>();
			
			while(result.next()) {
				ContactExterne contact = new ContactExterne(result.getString("nom_contact"), result.getString("nom_societe"));
				
				contact.setId_personne(result.getInt("id_Contact"));
				contact.setCivilite(result.getString("civilite"));
				contact.setCommentaire(result.getString("commentaire_contact"));
				contact.setPrenom_c(result.getString("prenom_contact"));
				contact.setAdresse(result.getString("adresse1_contact"));
				contact.setCp_c(result.getString("code_Postal_contact"));
				contact.setVille_c(result.getString("ville_contact"));
				contact.setTelephone_c(result.getString("telephone_contact"));
				contact.setMail_c(result.getString("mail_contact"));
						
				list.add(contact);
			}
			return list;
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
}
