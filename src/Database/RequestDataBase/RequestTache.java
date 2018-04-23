package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.DatabaseSettings;
import modele.Tache;

public class RequestTache {
	
	public Tache request(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM tache WHERE id = "+ id +";");
			
			Tache tache = new Tache(result.getString("libelle"), result.getDate("dateDebut"));
			tache.setCommentaire(result.getString("commentaire"));
			tache.setDateEcheance(result.getDate("dateEcheance"));
			tache.setEtatAvancement(result.getShort("etatAvancement"));
			tache.setDateRappel(result.getDate("dateRappel"));
			tache.setPriorite(result.getInt("priorite"));
			tache.setPredefinie(result.getBoolean("predefinie"));
			tache.setDateCreationTache(result.getDate("date_creation_tache"));

			return tache;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
	
}
