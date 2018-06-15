package rocher;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import vue.VueUnOnglet;

public class TabbedPaneEx {

	public static void createAndShowGUI() {

		// Create and set up the window.
		final JFrame frame = new JFrame("Split Pane Example");
		ImageIcon image= new ImageIcon("rocher/contacts.png");
		VueUnOnglet p = new VueUnOnglet();
		VueUnOnglet p2 = new VueUnOnglet();
		
		p2.setTest();

		// Display the window.
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Tab1",image ,p);
		tabbedPane.addTab("Tab2", p2);

		frame.getContentPane().add(tabbedPane);

	}

	private static JPanel makePanel(String text) {
		JPanel p = new JPanel();
		p.add(new Label(text));
		p.setLayout(new GridLayout(1, 1));
		return p;
	}

}