package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Database.DatabaseSettings;
import modele.contacts.Benevole;

public class RequestBenevole {
	//Obtenir un bénévole selon son ID
	public Benevole requestBenevole(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Benevole WHERE id_Personne = "+ id +";");
			
			if(result.next()) {
				Benevole contact = new Benevole(result.getString("nom_benevole"), result.getString("prenom_benevole"));
				
				contact.setId_personne(result.getInt("id_Personne"));
				contact.setCivilite(result.getString("civilite_benevole"));
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
	//Obtenir la liste complètes des bénévoles stockés
	public ArrayList<Benevole> requestAll() throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ArrayList<Benevole> list = new ArrayList<Benevole>();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Benevole;");
			
			while(result.next()) {
				Benevole contact = new Benevole(result.getString("nom_benevole"), result.getString("prenom_benevole"));
				
				contact.setId_personne(result.getInt("id_Personne"));
				contact.setCivilite(result.getString("civilite_benevole"));
				contact.setCommentaire(result.getString("commentaire_benevole"));
				contact.setPrenom_c(result.getString("prenom_benevole"));
				contact.setAdresse(result.getString("adresse_benevole"));
				contact.setCp_c(result.getString("codePostal_benevole"));
				contact.setVille_c(result.getString("ville_benevole"));
				contact.setTelephone_c(result.getString("telephone_benevole"));
				contact.setMail_c(result.getString("mail_personnel"));
						
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
