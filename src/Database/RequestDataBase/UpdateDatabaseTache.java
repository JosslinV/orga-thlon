	package Database.RequestDataBase;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import Database.DatabaseSettings;
	import java.util.Date ;

	public class UpdateDatabaseTache {


	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

		public void Update_libelle_tache ( String nom_course, int id) throws Exception {
			
		
			try {
				Connection database = DatabaseSettings.connect();

				preparedStatement = database.prepareStatement("UPDATE nom_course from Orgathlon.Course WHERE id_Course = " + id + "SET nom_course="+nom_course);
				resultSet = preparedStatement.executeQuery();		
				
			} catch (Exception e) {
				throw e;
			} finally {
				DatabaseSettings.close();
			}
		
		}
	
	
	

}
