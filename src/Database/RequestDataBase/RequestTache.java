package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DatabaseSettings;
import modele.Tache;

public class RequestTache {
	
	public Tache requestTache(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Tache WHERE id_Tache = "+ id +";");
			
			if(result.next()) {
				Tache tache = new Tache(result.getString("libelle"), result.getDate("dateDebut").toLocalDate());
				tache.setId_tache(result.getInt("id_Tache"));
				tache.setCommentaire(result.getString("commentaire"));
				tache.setDateEcheance(result.getDate("dateEcheance").toLocalDate());
				tache.setEtatAvancement(result.getShort("etatAvancement"));
				tache.setDateRappel(result.getDate("dateRappel").toLocalDate());
				tache.setPriorite(result.getInt("priorite"));
				tache.setDateCreationTache(result.getDate("date_creation_tache").toLocalDate());
	
				return tache;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
	
	public ArrayList<Tache> requestAll() throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ArrayList<Tache> list = new ArrayList<Tache>();
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Tache;");
			
			if(result.next()) {
				Tache tache = new Tache(result.getString("libelle"), result.getDate("dateDebut").toLocalDate());
				tache.setId_tache(result.getInt("id_Tache"));
				tache.setCommentaire(result.getString("commentaire"));
				tache.setDateEcheance(result.getDate("dateEcheance").toLocalDate());
				tache.setEtatAvancement(result.getShort("etatAvancement"));
				tache.setDateRappel(result.getDate("dateRappel").toLocalDate());
				tache.setPriorite(result.getInt("priorite"));
				tache.setDateCreationTache(result.getDate("date_creation_tache").toLocalDate());
	
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
