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

			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Tache SET libelle=?, commentaire=?, dateDebut=?, dateEcheance=?, etatAvancement=?, dateRappel=?, priorite=?, date_creation_tache=?, nom_createur=?, id_personne=?, predefinie=?, nomResponsable=?, prenomResponsable=? WHERE id_Tache=?");
			preparedStatement.setString(1, donnees.getLibelle());
			preparedStatement.setString(2, donnees.getCommentaire());
			preparedStatement.setObject(3, donnees.getDateDebut());
			preparedStatement.setObject(4, donnees.getDateEcheance());
			preparedStatement.setDouble(5, donnees.getEtatAvancement());
			preparedStatement.setObject(6, donnees.getDateRappel());
			preparedStatement.setInt(7, donnees.getPriorite());
			preparedStatement.setObject(8, donnees.getDateCreationTache());
			preparedStatement.setString(9, donnees.getNomAuteurTache());
			preparedStatement.setInt(10, donnees.getIdResponsable());
			preparedStatement.setBoolean(11, donnees.isPredefinie());
			preparedStatement.setString(12, donnees.getNomResponsableTache());
			preparedStatement.setString(13, donnees.getPrenomResponsableTache());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
	
}
