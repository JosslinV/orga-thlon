package vue;
import vue.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Kanban.VueAutourTabKanban;


	
	public class VueOnglets extends JPanel{
		
		/*
		public VueOnglets() {
			ImageIcon image= new ImageIcon("rocher/contacts.png");
			ImageIcon image2= new ImageIcon("rocher/f0_accueilpopupout.png");
			VueUnOnglet p = new VueUnOnglet();
			VueUnOnglet p2 = new VueUnOnglet();
			p2.setTest();
			
			this.addTab("tab1", image2, p);
			this.addTab("tab2", image, p2);
		}
		*/
		public VueOnglets() throws Exception {
			JTabbedPane onglets = new JTabbedPane();
		
			//JTabbedPane onglets2 = new JTabbedPane();
			VueAutourTabKanban p = new VueAutourTabKanban();
			VueAutourTabKanban p2 = new VueAutourTabKanban();
		
			
			this.setLayout(new GridLayout(1,2));
			
			
			onglets.setTabPlacement(JTabbedPane.TOP);
			//onglets.setOpaque(true);
			onglets.addTab("tab1", p);
			//onglets.setMnemonicAt(0, KeyEvent.VK_2);
			
			onglets.addTab("tab1", p2);
			//onglets.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			
			//onglets.setLayout(new GridLayout(2, 1));
			//onglets2.addTab("tab2", new ImageIcon("rocher/contacts.png"), p);
			
			this.add(onglets);
			//this.add(new JButton("texte"));
			//this.add(onglets2);
			
		}
		
		
}
