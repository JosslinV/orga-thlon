package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import Database.DatabaseSettings;

/*CREATE TABLE Benevole(
		   id_Personne SERIAL PRIMARY KEY,
		   nom_benevole VARCHAR(50),
		   prenom_benevole VARCHAR(50),
		   adresse_benevole VARCHAR(255),
		   codePostal_benevole VARCHAR(5),
		   ville_benevole VARCHAR(50),
		   mail_personnel VARCHAR(50),
		   telephone_benevole VARCHAR(50)
		);


public void updateDatabaseTache (String libelle, String commentaire, Date dateDebut, Date DateEcheance, float etatAvancement, Date DateRappel, int priorite, int predefinie, int frequence_rappel, Date date_creation, Date nom_createur, int id ) throws Exception {
	

	*/



public class UpdateDatabaseBenevole {
	
	public void UpdateDatabaseBenevole (int id_Personne, String nom_benevole, String prenom_benevole, String adresse_benevole, int CodePostal_benevole, String ville_benevole, String mail_benevole, String telephone_benevole) throws Exception{

	
	
	try {
		Connection database = DatabaseSettings.connect();

		String requete = "UPDATE orgathlon.benevole" + " SET nom_benevole='" + nom_benevole
													+"'AND prenom_benevole='" + prenom_benevole
													+"'AND adresse_benevole='" + adresse_benevole
													+"'AND CodePostal_benevole=" + CodePostal_benevole
													+"AND mail_benevole='" + mail_benevole
													+"'AND ville_benevole='" + ville_benevole
													+"'AND telephone_benevole='" + telephone_benevole
													+"'WHERE id_Personne = " + id_Personne ;
		Statement stmt = database.createStatement() ;
		stmt.executeQuery(requete) ;
		
	} catch (Exception e) {
		throw e;
	} finally {
		DatabaseSettings.close();
	}
	}
	}
