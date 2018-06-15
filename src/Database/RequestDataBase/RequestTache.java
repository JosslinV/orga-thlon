package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DatabaseSettings;
import modele.Tache;

public class RequestTache {
	
	// Obtenir une tâche selon son id
	public Tache requestTache(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Tache WHERE id_Tache = "+ id +";");
			
			if(result.next()) {
				Tache tache = new Tache(result.getString("libelle"),
				result.getDate("dateDebut").toLocalDate());
					
				tache.setId_tache(result.getInt("id_Tache"));
				tache.setCommentaire(result.getString("commentaire"));
				tache.setDateEcheance(result.getDate("dateEcheance").toLocalDate());
				tache.setEtatAvancement(result.getShort("etatAvancement"));
				tache.setDateRappel(result.getDate("dateRappel").toLocalDate());
				tache.setPriorite(result.getInt("priorite"));
				tache.setDateCreationTache(result.getDate("date_creation_tache").toLocalDate());
				tache.setNomAuteurTache(result.getString("nom_createur"));
				tache.setIdResponsable(result.getInt("id_Personne"));
				tache.setPredefinie(result.getBoolean("predefinie"));
				tache.setNomResponsableTache(result.getString("nomReponsable"));
				tache.setPrenomResponsableTache(result.getString("prenomResponsable"));
				tache.setEnPause(result.getBoolean("enPause"));
				
				
				
				return tache;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
	
	// Obtenir une liste complète de tâches
	public ArrayList<Tache> requestAll() throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ArrayList<Tache> list = new ArrayList<Tache>();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Tache;");
			
			while(result.next()) {
				Tache tache = new Tache(result.getString("libelle"), result.getDate("dateDebut").toLocalDate());
				tache.setId_tache(result.getInt("id_Tache"));
				tache.setId_tache(result.getInt("id_Tache"));
				tache.setCommentaire(result.getString("commentaire"));
				tache.setDateEcheance(result.getDate("dateEcheance").toLocalDate());
				tache.setEtatAvancement(result.getShort("etatAvancement"));
				tache.setDateRappel(result.getDate("dateRappel").toLocalDate());
				tache.setPriorite(result.getInt("priorite"));
				tache.setDateCreationTache(result.getDate("date_creation_tache").toLocalDate());
				tache.setNomAuteurTache(result.getString("nom_createur"));
				tache.setIdResponsable(result.getInt("id_Personne"));
				tache.setPredefinie(result.getBoolean("predefinie"));
				tache.setEnPause(result.getBoolean("enPause"));
				
				
				list.add(tache);
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
