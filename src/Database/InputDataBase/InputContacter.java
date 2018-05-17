package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Course;
import modele.contacts.Contact;

public class InputContacter {
	
	private PreparedStatement preparedStatement;

	public void inputGérer(Course course, Contact contact) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Contenir values (?,?)");
			preparedStatement.setInt(1, course.getId_course());
			preparedStatement.setInt(2, contact.getId_personne());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
