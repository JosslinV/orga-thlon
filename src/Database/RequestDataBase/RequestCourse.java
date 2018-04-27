package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.DatabaseSettings;
import modele.Course;

public class RequestCourse {
	
	public Course request(int id) throws Exception{
		try {
			Connection database = DatabaseSettings.connect();

			Statement state = database.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Course WHERE id_Course = "+ id +";");
			
			if(result.next()) {
				Course course = new Course(result.getString("nom_course"), result.getBoolean("agrementFTTRi"));
				
				course.setFormat(result.getString("format_course"));
				course.setDateC(result.getDate("date_course"));
				course.setDescriptionCourse(result.getString("description_course"));			
				course.setLieu(result.getString("lieu"));
				course.setBudget(result.getShort("budget"));
				course.setNbParticipants(result.getInt("nb_participants"));
				course.setParcours(result.getString("parcours"));
				course.setNom_ville(result.getString("nom_ville"));
				course.setCp_ville(result.getInt("CP_ville"));
				course.setType_epreuve(result.getString("type_epreuve"));	
				
				return course;
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
}