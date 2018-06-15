package rocher;

import java.util.ArrayList;
import java.util.List;

import modele.contacts.Benevole;

public class ModeleDynamiqueTableBenevole extends ModeleDynamiqueTable   {
    private final List<Benevole> benevoles = new ArrayList<Benevole>();
 
    private final String[] entetes = {"Commentaire", "Civilite", "Nom","prenom", "adresse", "code postal","ville","telephone","mail"};
 
    public ModeleDynamiqueTableBenevole(ArrayList<Object> al) {
        super();
 
        for ( Object b : al) {
        	 benevoles.add( (Benevole) b);
        }

    }
 
    public int getRowCount() {
        return benevoles.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return benevoles.get(rowIndex).getCommentaire();
            case 1:
                return benevoles.get(rowIndex).getCivilite();
            case 2:
                return benevoles.get(rowIndex).getNom_c();
            case 3:
                return benevoles.get(rowIndex).getPrenom_c();
            case 4:
                return benevoles.get(rowIndex).getAdresse();
            case 5:
            	return benevoles.get(rowIndex).getCp_c();
            case 6:
            	return benevoles.get(rowIndex).getVille_c();
            case 7:
            	return benevoles.get(rowIndex).getTelephone_c();
            case 8:
            	return benevoles.get(rowIndex).getMail_c();
            default:
                return null;
        }
    }
 
    public void add(Object contact) {
        benevoles.add((Benevole)contact);
        fireTableRowsInserted(benevoles.size() -1, benevoles.size() -1);
    }
 
    public void remove(int[] rowIndex) {
    	for(int i=rowIndex.length-1;i>=0;i--) {
        benevoles.remove(rowIndex[i]);
    	}
        fireTableRowsDeleted(rowIndex[0], rowIndex.length-1);
    }
}