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
	
}