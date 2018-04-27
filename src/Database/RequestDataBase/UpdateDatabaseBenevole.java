package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import Database.DatabaseSettings;
import modele.contacts.Benevole;

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
	
	public void UpdateDatabaseBenevole (Benevole donnees) throws Exception {
	//(int id_Personne, String nom_benevole, String prenom_benevole, String adresse_benevole, int CodePostal_benevole, String ville_benevole, String mail_benevole, String telephone_benevole) throws Exception{

	
	
	try {
		Connection database = DatabaseSettings.connect();

		String requete = "UPDATE orgathlon.benevole" + " SET nom_benevole='" + donnees.getNom_c()
													+"'AND prenom_benevole='" + donnees.getPrenom_c()
													+"'AND adresse_benevole='" + donnees.getAdresse()
													+"'AND CodePostal_benevole=" + donnees.getCp_c() 
													+"AND mail_benevole='" + donnees.getMail_c()
													+"'AND ville_benevole='" + donnees.getVille_c()
													+"'AND telephone_benevole='" + donnees.getTelephone_c()
													+"'WHERE id_Personne = " + donnees.getId_personne() ;
		Statement stmt = database.createStatement() ;
		stmt.executeQuery(requete) ;
		
	} catch (Exception e) {
		throw e;
	} finally {
		DatabaseSettings.close();
	}
	}
	}
