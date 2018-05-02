package Database.UpdateDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modele.Tache;
import Database.DatabaseSettings;

public class UpdateDatabaseTache {
	
	private static PreparedStatement preparedStatement = null;

	public void updateDatabaseTache(Tache donnees) {
	
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Tache SET libelle=?, commentaire=?, dateDebut=?, dateEcheance=?, etatAvancement=?, dateRappel=?, priorite=?, date_creation_tache=?, nom_createur=?, id_personne=?, predefinie=? WHERE id_Tache=?");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setString(2, donnees.getCommentaire());
			preparedStatement.setDate(3, null);									//date
			preparedStatement.setDate(4, null);								//date
			preparedStatement.setDouble(5, donnees.getEtatAvancement());
			preparedStatement.setDate(6, null);								//date
			preparedStatement.setInt(7, donnees.getPriorite());
			preparedStatement.setDate(8, null);								//date
			preparedStatement.setString(9, null);								//id_personne?
			preparedStatement.setString(10, null);							//createur ?
			preparedStatement.setBoolean(11, donnees.isPredefinie());
			preparedStatement.setInt(12, donnees.getId_Tache());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
}
