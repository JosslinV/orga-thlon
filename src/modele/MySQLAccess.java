package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/testorga?" + "user=sqluser&password=orgathlon");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from testorga.course");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("insert into  testorga.course values (default, ?, ?, ?, ? , ?, ?,?,?,?,?,?,?)");
            preparedStatement.setString(1, "");
            preparedStatement.setString(2, "");
            preparedStatement.setDate(3, new java.sql.Date(2009, 12, 11));
            preparedStatement.setString (4, "");
            preparedStatement.setString(5, "");
            preparedStatement.setString(6, "");
            preparedStatement.setInt(6, 1);
            preparedStatement.setDouble(7, 150.20);
            preparedStatement.setInt(8, 3);
            preparedStatement.setString(9, "");
            preparedStatement.setString(10, "");
            preparedStatement.setInt(11, 31400);
            preparedStatement.setString(12, "");
            preparedStatement.executeUpdate();

            preparedStatement = connect.prepareStatement("SELECT * from testorga.course");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStatement = connect.prepareStatement("delete from testorga.course where nom_course= ? ; ");
            preparedStatement.setString(1, "");
            preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("select * from testorga.course");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
   
    
    
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String nom = resultSet.getString("nom_course");
         
       
        }
    }
    
   
    
    
    // You need to close the resultSet
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
;
}





