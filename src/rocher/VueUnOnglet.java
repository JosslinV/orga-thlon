package rocher;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VueUnOnglet extends JPanel{
	private String test = new String("a");
	
	ImageIcon contact = new ImageIcon("rocher/contacts.png");
	
	
	public VueUnOnglet() {
		
		JButton b = new JButton(test);
		this.add(b);
		
	}
	
	public void setTest(){
		this.test = "b";
		this.add(new JButton(test));
	}

}
