package vue;

import java.util.ArrayList;
import java.util.List;

public class AppliTest {

	public static void main(String[] a) throws Exception {
		
	//	new VueNouveauMateriel();
		new VueNouvelleCourse();
		//new VueNouveauContactBenevole();
	//	new VueNouveauContactExterne();
	//	new Fenetre_NouvelleTache();
	//	new VueNouvelleSousTache();
		
		List<String> listeMat = new ArrayList<String>();
		listeMat.add("plots");
		listeMat.add("tee-shirts");
		listeMat.add("ballons");
		listeMat.add("stylos");
		new VueNouvelleListeMateriel(listeMat);
		
		List<String> listeBenevoles = new ArrayList<String>();
		listeBenevoles.add("Jules Utilise");
		listeBenevoles.add("Bernard Coquille");
		listeBenevoles.add("Super Man");
		listeBenevoles.add("Super Faignant");
		new VueNouvelleEquipe(listeBenevoles);
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
