package rocher;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueTableau extends JScrollPane{
	private JTable tableau;

    public VueTableau(ModeleDynamiqueTable modeleDynamiqueTable) {
    	this.tableau =new JTable(modeleDynamiqueTable);
        this.getViewport().add((tableau));
 
    }
 
   public JTable getJTable() {
	   return this.tableau;
	   
   }
}
