package modele;

public class Main {
    public static void main(String[] args) throws Exception {
       //MySQLAccess dao = new MySQLAccess();
        Course2 c2 = new Course2("testnom", false) ;
        System.out.println(c2.getNom(1)) ;
      // dao.readDataBase();
    }

}