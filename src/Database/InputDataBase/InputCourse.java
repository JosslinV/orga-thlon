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
																+donnees.getDistance_nat()+","
																+donnees.getDistance_cyc()+","
																+donnees.getDistance_cou()+","
																+donnees.getNom_ville_nat()+","
																+donnees.getNom_ville_cyc()+","
																+donnees.getNom_ville_cou()+","
																+donnees.getNom_ville_arr()+","
																+donnees.getCP_ville_nat()+","
																+donnees.getCP_ville_cyc()+","
																+donnees.getCP_ville_cou()+","
																+donnees.getCP_ville_arr()+","
															
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
