package controleur;




	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import Kanban.VueAutourTabKanban;
	import javax.swing.JButton;
	import vue.VueNouvelleCourse;

		
	public class ControleurAutourTableauKanban implements ActionListener {
		
		private VueAutourTabKanban vue;

		
		
		public ControleurAutourTableauKanban(VueAutourTabKanban vue) throws Exception {	
			this.vue = vue ;
			//this.modele = new modele.Course("nouveau") ;
			
		}
		
		public void actionPerformed (ActionEvent e) {
			JButton b = (JButton) e.getSource() ;
				
					if (b.getText().equals("Nouvelle Course")) {
						
						
					
						
						try {
							new VueNouvelleCourse();
							
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
								
						

				
						
					}
				
				
					
				}
				
				
	}