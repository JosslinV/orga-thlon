package vue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import Database.RequestDataBase.RequestBenevole;
import Database.RequestDataBase.RequestMateriel;
import modele.Materiel;
import modele.contacts.Benevole;

public class AppliTest {

	public static void main(String[] a) throws Exception {
		

		//new VueNouveauMateriel();
		//new VueNouvelleCourse();
		//new VueNouveauContactBenevole();
		//new VueNouveauContactExterne();
	
	//	new VueNouvelleSousTache();

		
		RequestMateriel reqMat = new RequestMateriel();
		ArrayList<Materiel> materiels = reqMat.requestAll();
		ArrayList<String> nom = new ArrayList<String>();
		for(Materiel m: materiels) {
		    nom.add(m.toString());
		  
		}
		//new Fenetre_NouvelleTache();
		//new VueNouvelleListeMateriel(nom);
		//new VueQuantiteMateriel(null, null);


		RequestBenevole reqBen = new RequestBenevole();
		ArrayList<Benevole> benevoles = reqBen.requestAll();
		ArrayList<String> nomBen = new ArrayList<String>();
		for(Benevole m: benevoles) {
			nomBen.add(m.toString());
		new VueNouvelleEquipe(nomBen);
		}
		/*
		Object [][] donneesSousTaches = new Object [5][2];
		TreeMap<String, Float> mapSousTaches = new TreeMap<String, Float>();
		mapSousTaches.put("faire1", 0.8F);
		mapSousTaches.put("faire2", 0.2F);
		mapSousTaches.put("faire3", 0.9F);
		mapSousTaches.put("faire4", 0.5F);
		mapSousTaches.put("faire5", 0.6F);
		
		Iterator <String> itLibelles = mapSousTaches.keySet().iterator();
		int numeroSousTache = 0;
		while (itLibelles.hasNext() && numeroSousTache < 5) {
				String cle = itLibelles.next();
				donneesSousTaches[numeroSousTache][0]= cle ;
				donneesSousTaches[numeroSousTache][1]= mapSousTaches.get(cle);
				System.out.println("numeroSousTache"+ numeroSousTache + "libelle :"+ donneesSousTaches[numeroSousTache][0] + "TauxCompletion :"+ donneesSousTaches[numeroSousTache][1] );
				numeroSousTache ++;
	
		};
		*/


		

	}
	
	
	
}
