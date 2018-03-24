package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.DatabaseSettings;

public class RequestCourse {

	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static String requestNom(int id) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT nom_course from Orgathlon.Course WHERE id_Course = " + id);
			resultSet = preparedStatement.executeQuery();

			String nom = "";

			while (resultSet.next()) {
				nom += resultSet.getString("nom_course");
			}
			return nom;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
<<<<<<< HEAD
		
=======

	public static String requestFormat(int id) throws Exception {
		//Au lieu de retourner le nom, retourne un select du nom pour une course donnée 

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT format_course from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String format="" ;

			while(resultSet.next()) {

				format = format + resultSet.getString("format_course");

			}

			return format;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}

	}

	public static String getDateC(int id) throws Exception {

		//Au lieu de retourner le nom, retourne un select du nom pour une course donnée 

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "date_course from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String date_course="" ;

			while(resultSet.next()) {

				date_course = date_course + resultSet.getString("date_course");

			}

			return date_course;



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

	public String getDescriptionCourse(int id) throws Exception {

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "description_course from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String description_course="" ;

			while(resultSet.next()) {

				description_course = description_course + resultSet.getString("description_course");

			}

			return description_course;



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
	public String getLieu(int id) throws Exception {

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "lieu from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String lieu="" ;

			while(resultSet.next()) {

				lieu = lieu + resultSet.getString("lieu");

			}

			return lieu;



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
	public int getNbParticipants(int id) throws Exception {

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "nb_participants from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String nb_participants="" ;

			while(resultSet.next()) {

				nb_participants = nb_participants + resultSet.getString("nb_participants");

			}

			return Integer.parseInt( nb_participants,10) ;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
	public String getParcours(int id) throws Exception{

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "parcours from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String parcours="" ;

			while(resultSet.next()) {

				parcours = parcours + resultSet.getString("parcours");

			}

			return parcours;



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

	public double getBudget(int id) throws Exception {
		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "budget from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String budget="" ;

			while(resultSet.next()) {

				budget = budget + resultSet.getString("budget");

			}

			return Double.parseDouble( budget) ;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

	public String getNom_ville(int id) throws Exception {

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "nom_ville from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String nom_ville="" ;

			while(resultSet.next()) {

				nom_ville = nom_ville + resultSet.getString("nom_ville");

			}

			return nom_ville;



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}

	public int getCp_ville(int id) throws Exception{

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "CP_ville from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String CP_ville="" ;

			while(resultSet.next()) {

				CP_ville = CP_ville + resultSet.getString("CP_ville");

			}

			return Integer.parseInt(CP_ville,10);



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}

	}	


	public String getType_epreuve(int id) throws Exception{

		try {

			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT " + "type_epreuve from Orgathlon.course WHERE id_Course = "+id);
			resultSet = preparedStatement.executeQuery();

			String type_epreuve="" ;

			while(resultSet.next()) {

				type_epreuve = type_epreuve + resultSet.getString("type_epreuve");

			}

			return type_epreuve;



		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}

	}














>>>>>>> refs/remotes/origin/master
}
