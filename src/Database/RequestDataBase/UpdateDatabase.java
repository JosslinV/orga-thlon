package Database.RequestDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.DatabaseSettings;
import java.util.Date ;

public class UpdateDatabase {






private static PreparedStatement preparedStatement = null;
private static ResultSet resultSet = null;

	public void UpdateNomC( String nom_course, int id) throws Exception {
		
	
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE nom_course from Orgathlon.Course WHERE id_Course = " + id + "SET nom_course="+nom_course);
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

			preparedStatement = database.prepareStatement("UPDATE format_course from Orgathlon.Course WHERE id_Course = " + id + "SET format_course="+format_course);
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

			preparedStatement = database.prepareStatement("UPDATE date_course from Orgathlon.Course WHERE id_Course = " + id + "SET date_course="+date_course);
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

			preparedStatement = database.prepareStatement("UPDATE description_course from Orgathlon.Course WHERE id_Course = " + id + "SET description_course="+description_course);
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

			preparedStatement = database.prepareStatement("UPDATE lieu from Orgathlon.Course WHERE id_Course = " + id + "SET lieu="+lieu);
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

			preparedStatement = database.prepareStatement("UPDATE nb_participants from Orgathlon.Course WHERE id_Course = " + id + "SET nb_participants="+nb_participants);
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

			preparedStatement = database.prepareStatement("UPDATE nb_participants from Orgathlon.Course WHERE id_Course = " + id + "SET parcours="+parcours);
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

			preparedStatement = database.prepareStatement("UPDATE budget from Orgathlon.Course WHERE id_Course = " + id + "SET budget="+budget);
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

			preparedStatement = database.prepareStatement("UPDATE budagrementget from Orgathlon.Course WHERE id_Course = " + id + "SET agrement="+agrement);
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

			preparedStatement = database.prepareStatement("UPDATE nom_ville from Orgathlon.Course WHERE id_Course = " + id + "SET nom_ville="+nom_ville);
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

			preparedStatement = database.prepareStatement("UPDATE CP_ville from Orgathlon.Course WHERE id_Course = " + id + "SET CP_ville="+CP_ville);
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

			preparedStatement = database.prepareStatement("UPDATE type_epreuve from Orgathlon.Course WHERE id_Course = " + id + "SET type_epreuve="+type_epreuve);
			preparedStatement.executeUpdate();			
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
}