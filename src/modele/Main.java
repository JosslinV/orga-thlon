package modele;

import java.util.Date;

import Database.InputDataBase.InputCourse;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	Course c2 = new Course("coucou",false);
    	c2.setDateC(new Date());
    	InputCourse.input(c2);
    }
}