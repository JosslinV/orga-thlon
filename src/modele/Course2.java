package modele;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner ;


public class Course2 {
	
	private String nom_course;
	private String format;
	private Date date_course;
	private String description_course;
	private String lieu_course;
	private int nbParticipants;
	private String parcours;
	private String commentaire_course;
	private float budget;
	private String nom_ville;
	private int cp_ville;
	private String type_epreuve;
	private int duree;
	private boolean agrement;
	private boolean predefini;
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
    private String serveur = "intra.info.iut-tlse3.fr/Orgathlon";
	
	
	
	public Course2 (String nom1, boolean predefini) throws Exception {
		
		
		 try {
	      Class.forName("com.mysql.jdbc.Driver");
		  connect = DriverManager.getConnection("jdbc:mysql://192.168.1.22/Orgathlon" + "?user=ptutas3&password=Mdp2ptutas3");
		  
		  preparedStatement = connect.prepareStatement("insert into  Orgathlon.Course values (default, ?, ?, ?, ? , ?, ?,?,?,?,?,?,?)");
          preparedStatement.setString(1, nom1);
          preparedStatement.setString(2, "");
          preparedStatement.setDate(3, new java.sql.Date(1900, 01, 01));
          preparedStatement.setString (4, "");
          preparedStatement.setString(5, "");
          preparedStatement.setBoolean(6, predefini);
          preparedStatement.setDouble(7, 0);
          preparedStatement.setInt(8, 3);
          preparedStatement.setString(9, "");
          preparedStatement.setString(10, "");
          preparedStatement.setInt(11, 00000);
          preparedStatement.setString(12, "");
          preparedStatement.executeUpdate();
          
		 } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	}
	
	public String getNom(int id) throws Exception {
		//Au lieu de retourner le nom, retourne un select du nom pour une course donnée 
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/testorga?" + "user=sqluser&password=orgathlon");
		statement = connect.createStatement();
		//resultSet = statement.executeQuery("select * from testorga.course");
       
         
		preparedStatement = connect.prepareStatement("SELECT nom_course from testorga.course WHERE id_Course = "+id);
        resultSet = preparedStatement.executeQuery();
        
        String nom="" ;
        
      while(resultSet.next()) {
    	  
       nom = nom + resultSet.getString("nom_course");
       
      }
		return nom;
		
        
        
		
	} catch (Exception e) {
        throw e;
    } finally {
        close();
    }

	}

	public void setNom(String nom) {
		this.nom_course = nom;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public Date getDateC() {
		return date_course;
	}

	public void setDateC(Date dateC) {
		this.date_course = dateC;
	}

	public String getDescriptionCourse() {
		return description_course;
	}

	public void setDescriptionCourse(String descriptionCourse) {
		this.description_course = descriptionCourse;
	}

	public String getLieu() {
		return lieu_course;
	}

	public void setLieu(String lieu) {
		this.lieu_course = lieu;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public String getParcours() {
		return parcours;
	}

	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public String getCommentaire() {
		return commentaire_course;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire_course = commentaire;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public int getCp_ville() {
		return cp_ville;
	}

	public void setCp_ville(int cp_ville) {
		this.cp_ville = cp_ville;
	}

	public String getType_epreuve() {
		return type_epreuve;
	}

	public void setType_epreuve(String type_epreuve) {
		this.type_epreuve = type_epreuve;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isAgrement() {
		return agrement;
	}

	public void setAgrement(boolean agrement) {
		this.agrement = agrement;
	}

	public boolean isPredefini() {
		return predefini;
	}

	public void setPredefini(boolean predefini) {
		this.predefini = predefini;
	}
	
	/*
	 * public void affecter(tache t, contact c) {
		
	}
	*/
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String nom = resultSet.getString("nom_course");
         
           
        }
	
}
	
	 private void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {

	        }
	        
	        
	    }

	 


}
