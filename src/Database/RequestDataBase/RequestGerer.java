package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Database.DatabaseSettings;
import modele.Tache;
import modele.contacts.Benevole;

public class RequestGerer {
	
	private List<Tache> list;

	public List<Tache> requestUtiliser(Benevole ben) {
		try {
			Connection database = DatabaseSettings.connect();
			Statement state = database.createStatement();
			
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Utiliser WHERE id_Materiel = "+ ben.getId_personne() +";");
			
			this.list = new LinkedList<Tache>();
			
			while(result.next()) {
				RequestTache reqTac = new RequestTache();
				Tache tac = reqTac.requestTache(result.getInt("id_Tache"));
				
				this.list.add(tac);
			}
			return this.list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
}
