package Kanban;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Fenetre_Kanban extends JFrame{
	public Fenetre_Kanban() {
		VueTabKanban vue = new VueTabKanban();
		this.add(vue);
		this.setTitle("TABLEAU KANBAN");
		this.setLayout(new GridLayout(1,1));
		this.pack();
		this.setSize(1160, 650);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}

