	package Database.RequestDataBase;

	import java.sql.Connection;
	import java.sql.Statement;
	import java.util.Date;

	import Database.DatabaseSettings;
import modele.contacts.ContactExterne;

public class UpdateDatabaseContactExt {



	/*CREATE TABLE Contact_Ext(
   id_Contact SERIAL PRIMARY KEY,
   type_contact VARCHAR(50),
   nomSociete VARCHAR(50),
   nom_contact VARCHAR(50),
   prenom_contact VARCHAR(50),
   adresse1_contact VARCHAR(255),
   code_Postal_contact VARCHAR(5),
   ville_contact VARCHAR(50),
   telephone_contact VARCHAR(10),
   mail_contact VARCHAR(255)
);
	

		*/

	public void UpdateDatabaseContactExt (ContactExterne donnees ) throws Exception {
	//(int id_Contact, String nomSociete, String nom_c, String prenom_c, String adresse, int cp_c, String ville_c, String mail_c, String telephone_c) throws Exception {
				
		try {
			Connection database = DatabaseSettings.connect();

			String requete = "UPDATE orgathlon.Contact_Ext" + " SET nom_c='" + donnees.getNom_c()
														+"'AND nomSociete='" + donnees.getNomSociete()
														+"'AND prenom_c='" + donnees.getPrenom_c()
														+"'AND adresse='" + donnees.getAdresse()
														+"'AND cp_c=" + donnees.getCp_c()
														+"AND mail_c='" + donnees.getMail_c()
														+"'AND ville_c='" + donnees.getVille_c()
														+"'AND telephone_c='" + donnees.getTelephone_c()
														+"'WHERE id_Contact = " + donnees.getId_personne() ;
			Statement stmt = database.createStatement() ;
			stmt.executeQuery(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
		
		


