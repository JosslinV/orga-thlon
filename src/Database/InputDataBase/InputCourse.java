package Database.InputDataBase;

import java.sql.Connection;
import java.sql.Date;

import modele.Course;
import java.sql.PreparedStatement;
import java.sql.Statement;

import Database.DatabaseSettings;

public class InputCourse {
    
	public static void input(Course donnees) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			String requeteCourse = "INSERT into Orgathlon.Tache VALUES (default,"
																+donnees.getNom()+","
																+donnees.getFormat()+","
																+null+","
																+donnees.getDescriptionCourse()+","
																+donnees.getLieu()+","
																+donnees.isAgrement()+","
																+donnees.getBudget()+","
																+donnees.getNbParticipants()+","
																+donnees.getParcours()+","
																+donnees.getNom_ville()+","
																+donnees.getCp_ville()+","
																+donnees.getType_epreuve()+");";
			
			Statement stmt = database.createStatement() ;
			stmt.execute(requeteCourse) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
