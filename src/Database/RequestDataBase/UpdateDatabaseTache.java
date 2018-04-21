	package Database.RequestDataBase;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
import java.sql.Statement;

import Database.DatabaseSettings;
	import java.util.Date ;

	public class UpdateDatabaseTache {


//	private static PreparedStatement preparedStatement = null;
//	private static ResultSet resultSet = null;


	public void updateDatabaseTache (int id_Tache, String libelle, String commentaire, Date dateDebut, Date DateEcheance, float etatAvancement, Date DateRappel, int priorite, int predefinie, int frequence_rappel, Date date_creation, Date nom_createur ) throws Exception {
		
		try {
			Connection database = DatabaseSettings.connect();

			String requete = "UPDATE orgathlon.tache" + " SET libelle='" + libelle
														+"'AND commentaire='" + commentaire
														+"'AND `dateDebut`=\"" + dateDebut
														+"\"AND `DateEcheance`=\"" + DateEcheance
														+"\"AND etatAvancement=" + etatAvancement
														+"AND `DateRappel`=\"" + DateRappel
														+"\"AND priorite=" + priorite
														+"AND predefinie=" + predefinie
														+"AND frequence_rappel=" + frequence_rappel
														+"AND `date_creation`=\"" + date_creation
														+"\"AND nom_createur='" + nom_createur 
														+"'WHERE id_Tache = " + id_Tache ;
			Statement stmt = database.createStatement() ;
			stmt.executeQuery(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
/*	
	public void Updatelibelle( String libelle, int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET libelle='" + libelle + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateCommentaire( String commentaire, int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET commentaire='" + commentaire + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateDateDebut( Date dateDebut , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET dateDebut='" + dateDebut + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}

	
	
	public void UpdateDateEcheance( Date dateEcheance , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET dateEcheance='" + dateEcheance + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateEtatAvancement ( float etatAvancement , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET etatAvancement='" + etatAvancement + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateDateRappel ( Date DateRappel , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET DateRappel='" + DateRappel + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateDateRappel ( int priorite , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET priorite='" + priorite + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdatePriorité ( int priorite , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET priorite='" + priorite + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdatePredefinie ( int predefinie , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET predefinie='" + predefinie + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
		
	public void UpdateFrequence_rappel ( String frequence_rappel , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET frequence_rappel='" + frequence_rappel + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	
	public void UpdateDate_creation ( Date date_creation , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET date_creation='" + date_creation + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	public void UpdateNom_createur ( Date nom_createur , int id) throws Exception {
		
		
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE orgathlon.tache" + " SET nom_createur='" + nom_createur + "' WHERE id_Course = " + id );
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	
	}
	
	*/
}
