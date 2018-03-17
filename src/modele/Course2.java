package modele;

import java.sql.DriverManager;
import java.lang.*;
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
	private double budget;
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
		  connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon" + "?user=ptutas3&password=Mdp2ptutas3");
		  
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
		connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
		statement = connect.createStatement();
		//resultSet = statement.executeQuery("select * from testorga.course");
       
         
		preparedStatement = connect.prepareStatement("SELECT nom_course from Orgathlon.course WHERE id_Course = "+id);
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

	
	public String getFormat(int id) throws Exception {
			//Au lieu de retourner le nom, retourne un select du nom pour une course donnée 
			
			try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT format_course from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String format="" ;
	        
	      while(resultSet.next()) {
	    	  
	       format = format + resultSet.getString("format_course");
	       
	      }
			
			return format;
			
			} catch (Exception e) {
		        throw e;
		    } finally {
		        close();
		    }

			}
	

	public void setFormat(String format) throws Exception {
		this.format = format;
	}
	
	public String getDateC(int id) throws Exception {
		
		//Au lieu de retourner le nom, retourne un select du nom pour une course donnée 
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
		statement = connect.createStatement();
       
         
		preparedStatement = connect.prepareStatement("SELECT " + "date_course from Orgathlon.course WHERE id_Course = "+id);
        resultSet = preparedStatement.executeQuery();
        
        String date_course="" ;
        
      while(resultSet.next()) {
    	  
    	  date_course = date_course + resultSet.getString("date_course");
       
      }
		
      return date_course;
		
		
		
	} catch (Exception e) {
        throw e;
    } finally {
        close();
    }

	}

	public void setDateC(Date dateC) {
		this.date_course = dateC;
	}

	public String getDescriptionCourse(int id) throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "description_course from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String description_course="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  description_course = description_course + resultSet.getString("description_course");
	       
	      }
			
	      return description_course;
			
			
			
		} catch (Exception e) {
	        throw e;
	    } finally {
	        close();
	    }

		}
		
	

	public void setDescriptionCourse(String descriptionCourse) {
		this.description_course = descriptionCourse;
	}

	public String getLieu(int id) throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "lieu from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String lieu="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  lieu = lieu + resultSet.getString("lieu");
	       
	      }
			
	      return lieu;
			
			
			
		} catch (Exception e) {
	        throw e;
	    } finally {
	        close();
	    }

		}


	public void setLieu(String lieu) {
		this.lieu_course = lieu;
	}

	public int getNbParticipants(int id) throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "nb_participants from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String nb_participants="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  nb_participants = nb_participants + resultSet.getString("nb_participants");
	       
	      }
			
	      return Integer.parseInt( nb_participants,10) ;
	
	} catch (Exception e) {
        throw e;
    } finally {
        close();
    }

	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public String getParcours(int id) throws Exception{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "parcours from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String parcours="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  parcours = parcours + resultSet.getString("parcours");
	       
	      }
			
	      return parcours;
			
			
			
		} catch (Exception e) {
	        throw e;
	    } finally {
	        close();
	    }

		}
	

	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public double getBudget(int id) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "budget from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String budget="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  budget = budget + resultSet.getString("budget");
	       
	      }
			
	      return Double.parseDouble( budget) ;
	
	} catch (Exception e) {
        throw e;
    } finally {
        close();
    }

	}
	

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public String getNom_ville(int id) throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "nom_ville from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String nom_ville="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  nom_ville = nom_ville + resultSet.getString("nom_ville");
	       
	      }
			
	      return nom_ville;
			
			
			
		} catch (Exception e) {
	        throw e;
	    } finally {
	        close();
	    }

		}
	

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public int getCp_ville(int id) throws Exception{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "CP_ville from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String CP_ville="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  CP_ville = CP_ville + resultSet.getString("CP_ville");
	       
	      }
			
	      return Integer.parseInt(CP_ville,10);
			
			
			
		} catch (Exception e) {
	        throw e;
	    } finally {
	        close();
	    }

		}
	


	public void setCp_ville(int cp_ville) {
		this.cp_ville = cp_ville;
	}

	public String getType_epreuve(int id) throws Exception{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://infra.info.iut-tlse3.fr:3306/Orgathlon?" + "user=ptutas3&password=Mdp2ptutas3");
			statement = connect.createStatement();
	       
	         
			preparedStatement = connect.prepareStatement("SELECT " + "type_epreuve from Orgathlon.course WHERE id_Course = "+id);
	        resultSet = preparedStatement.executeQuery();
	        
	        String type_epreuve="" ;
	        
	      while(resultSet.next()) {
	    	  
	    	  type_epreuve = type_epreuve + resultSet.getString("type_epreuve");
	       
	      }
			
	      return type_epreuve;
			
			
			
		} catch (Exception e) {
	        throw e;
	    } finally {
	        close();
	    }

		}
	

	public void setType_epreuve(String type_epreuve) {
		this.type_epreuve = type_epreuve;
	}

	public int getDuree() {
		//calculée, il faut 2 dates : début et fin de la course
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
