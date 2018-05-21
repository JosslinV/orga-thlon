package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Database.DatabaseSettings;
import modele.Course;
import modele.contacts.Benevole;

public class RequestContacter {
	
	private List<Benevole> list;

	public  List<Benevole> requestUtiliser(Course course) {
		try {
			Connection database = DatabaseSettings.connect();
			Statement state = database.createStatement();
			
			ResultSet result = state.executeQuery("SELECT * FROM Orgathlon.Utiliser WHERE id_Materiel = "+ course.getId_course() +";");
			
			this.list = new LinkedList<Benevole>();
			
			while(result.next()) {				
				RequestBenevole reqBen = new RequestBenevole();
				Benevole ben = (Benevole)reqBen.requestBenevole(result.getInt("id_Personne"));
				
				this.list.add(ben);	
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
