package modele;

import Database.InputDataBase.InputContact;
import Database.InputDataBase.InputCourse;
import Database.InputDataBase.InputTache;
import Database.RequestDataBase.RequestContactExt;
import Database.RequestDataBase.RequestCourse;
import Database.RequestDataBase.UpdateDatabaseContactExt;
import modele.contacts.Contact;
import modele.contacts.ContactExterne;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	RequestContactExt req = new RequestContactExt();
    	Contact test = req.request(1);
    	Contact test2 = new ContactExterne("Roger","Chevalier");
    	InputContact.input(test2);
    	System.out.println(test.getPrenom_c().getClass());
    	System.out.println(test2.getPrenom_c());
    	
    	test2.setPrenom_c("Max");
    	UpdateDatabaseContactExt up = new UpdateDatabaseContactExt();
    	up.UpdateDatabaseContactExt((ContactExterne)test2);
    }
    
}