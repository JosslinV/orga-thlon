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
			ResultSet result = state.executeQuery("SELECT * FROM course WHERE id = "+ id +";");
			
			Course course = new Course(result.getString("nom_course"), result.getBoolean("agrementFTTri"));
			course.setFormat(result.getString("format_course"));
			course.setDateC(result.getDate("date_course"));
			course.setDescriptionCourse(result.getString("description_course"));			
			course.setLieu(result.getString("lieu"));
			course.setBudget(result.getShort("budget"));
			course.setNbParticipants(result.getInt("nb_participants"));
			course.setParcours(result.getString("parcours"));
			course.setNom_ville_nat(result.getString("nom_ville_nat"));
			course.setNom_ville_cyc(result.getString("nom_ville_cyc"));
			course.setNom_ville_cou(result.getString("nom_ville_cou"));
			course.setNom_ville_arr(result.getString("nom_ville_arr"));
			course.setCP_ville_nat(result.getString("CP_ville_nat"));
			course.setCP_ville_cyc(result.getString("CP_ville_cyc"));
			course.setCP_ville_cou(result.getString("CP_ville_cou"));
			course.setCP_ville_arr(result.getString("CP_ville_arr"));
			course.setDistance_nat(result.getInt("distance_nat"));
			course.setDistance_cyc(result.getInt("distance_cyc"));
			course.setDistance_cou(result.getInt("distance_cou"));
			course.setType_epreuve(result.getString("type_epreuve"));		
			
			return course;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		return null;
	}
	;
}
