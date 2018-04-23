package Database.RequestDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.DatabaseSettings;
import java.util.Date ;
import java.sql.Statement ;

public class UpdateDatabase {






//private static PreparedStatement preparedStatement = null;
//private static ResultSet resultSet = null;


public void updateDatabase (String nom_course, String format_course, Date date_course, String description_course, String lieu, int nb_participants, String parcours, float budget, int agrement, String nom_ville_nat, String nom_ville_cyc, String nom_ville_cou, String nom_ville_arr, int CP_ville, int CP_ville_nat, int CP_ville_cyc, int CP_ville_cou, int CP_ville_arr, int type_epreuve, int distance_nat, int distance_cyc, int distance_cou, int id  ) throws Exception {
	
	try {
		Connection database = DatabaseSettings.connect();

		String requete = "UPDATE orgathlon.course" + " SET nom_course='" + nom_course 
													+"'AND format_course='" + format_course
													+"'AND `date_course`=\"" + date_course
													+"\"AND description_course='" + description_course
													+"'AND lieu='" + lieu
													+"'AND nb_participants=" + nb_participants
													+"AND parcours='" + parcours
													+"'AND budget=" + budget
													+"AND agrement=" + agrement
													+"AND nom_ville_nat='" + nom_ville_nat
													+"'AND nom_ville_cyc='" + nom_ville_cyc
													+"'AND nom_ville_cou='" + nom_ville_cou
													+"'AND nom_ville_arr='" + nom_ville_arr
													+"'AND CP_ville_nat=" + CP_ville_nat
													+"AND CP_ville_cyc=" + CP_ville_cyc
													+"AND CP_ville_cou=" + CP_ville_cou
													+"AND CP_ville_arr=" + CP_ville_arr
													+"AND distance_nat=" + distance_nat
													+"AND distance_cyc=" + distance_cyc
													+"AND distance_cou=" + distance_cou
													+"AND type_epreuve='" + type_epreuve
													+"'WHERE id_Course = " + id ;
		Statement stmt = database.createStatement() ;
		stmt.executeQuery(requete) ;
		
	} catch (Exception e) {
		throw e;
	} finally {
		DatabaseSettings.close();
	}
	
}



/*

	public void UpdateNomC( String nom_course, int id) throws Exception {
		
	
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET nom_course='" + nom_course + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateFormatC( String format_course, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET format_course='" + format_course + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateDateC( Date date_course , int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET date_course='" + date_course + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	

	
	
	public void UpdateDescriptionC( String description_course, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET description_course='" + description_course + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateLieu( String lieu, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET lieu='" + lieu + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateNbParticipants( int nb_participants, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET nb_participants='" + nb_participants + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();			
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateParcours( String parcours, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET parcours='" + parcours + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
		public void UpdateBudget( float budget, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET budget='" + budget + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateagrémentFTTRi( int agrement, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET agrement='" + agrement + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateNom_VIlle( String nom_ville, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET nom_ville='" + nom_ville + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();			
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateCP_Ville( int CP_ville, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET CP_ville='" + CP_ville + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateType_Epreuve( int type_epreuve, int id) throws Exception {
		
		
		try {
			
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.course" + " SET type_epreuve='" + type_epreuve + "' WHERE id_Course = " + id );			
			preparedStatement.executeUpdate();			
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
*/


}