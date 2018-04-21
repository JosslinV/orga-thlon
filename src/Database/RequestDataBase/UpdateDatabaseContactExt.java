	package Database.RequestDataBase;

	import java.sql.Connection;
	import java.sql.Statement;
	import java.util.Date;

	import Database.DatabaseSettings;

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

	public void UpdateDatabaseContactExt(int id_Contact, String nomSociete, String nom_c, String prenom_c, String adresse, int cp_c, String ville_c, String mail_c, String telephone_c) throws Exception {
				
		try {
			Connection database = DatabaseSettings.connect();

			String requete = "UPDATE orgathlon.Contact_Ext" + " SET nom_c='" + nom_c
														+"'AND nomSociete='" + nomSociete
														+"'AND prenom_c='" + prenom_c
														+"'AND adresse='" + adresse
														+"'AND cp_c=" + cp_c
														+"AND mail_c='" + mail_c
														+"'AND ville_c='" + ville_c
														+"'AND telephone_c='" + telephone_c
														+"'WHERE id_Contact = " + id_Contact ;
			Statement stmt = database.createStatement() ;
			stmt.executeQuery(requete) ;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
		
		


