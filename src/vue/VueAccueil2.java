package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurGeneral;
import rocher.ListeBenevoles;
import rocher.VueOnglets;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VueAccueil2 extends JFrame {

	private JPanel contentPane;
	private JPanel panneauPrincipal;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAccueil2 frame = new VueAccueil2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueAccueil2() throws Exception{
		ControleurGeneral controleur = new ControleurGeneral(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 580);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		JPanel BandeauGauche = new JPanel();
		this.contentPane.add(BandeauGauche, BorderLayout.WEST);
		GridBagLayout gbl_BandeauGauche = new GridBagLayout();
		gbl_BandeauGauche.columnWidths = new int[]{0, 0};
		gbl_BandeauGauche.rowHeights = new int[]{0, 0, 0, 0};
		gbl_BandeauGauche.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_BandeauGauche.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		BandeauGauche.setLayout(gbl_BandeauGauche);
		
		JButton btnCourses = new JButton();
		btnCourses.setIcon(new ImageIcon("./src/RessourcesImages/Alarm-128.png","ImgCourse"));
		GridBagConstraints gbc_btnCourses = new GridBagConstraints();
		gbc_btnCourses.insets = new Insets(0, 0, 5, 0);
		gbc_btnCourses.gridx = 0;
		gbc_btnCourses.gridy = 0;
		BandeauGauche.add(btnCourses, gbc_btnCourses);
		btnCourses.addActionListener(controleur);
		
		JButton btnContacts = new JButton();
		btnContacts.setIcon(new ImageIcon("./src/RessourcesImages/equipe.png","ImgContacts"));
		GridBagConstraints gbc_btnContacts = new GridBagConstraints();
		gbc_btnContacts.insets = new Insets(0, 0, 5, 0);
		gbc_btnContacts.gridx = 0;
		gbc_btnContacts.gridy = 1;
		BandeauGauche.add(btnContacts, gbc_btnContacts);
		btnContacts.addActionListener(controleur);
		
		JButton btnMateriel = new JButton();
		btnMateriel.setIcon(new ImageIcon("./src/RessourcesImages/Shape-Cube-128.png","ImgMateriel"));
		GridBagConstraints gbc_btnMateriel = new GridBagConstraints();
		gbc_btnMateriel.gridx = 0;
		gbc_btnMateriel.gridy = 2;
		BandeauGauche.add(btnMateriel, gbc_btnMateriel);
		btnMateriel.addActionListener(controleur);
		
		this.panneauPrincipal = new JPanel();
		this.contentPane.add(this.panneauPrincipal, BorderLayout.CENTER);
		this.cardLayout = new CardLayout(0, 0);
		this.panneauPrincipal.setLayout(this.cardLayout);
		
		JPanel pannelCourses = new VueOnglets();
		this.panneauPrincipal.add(pannelCourses, "TableauKanban");
		
		JPanel panelContacts = new BenevolesOuContacts2();
		this.panneauPrincipal.add(panelContacts, "BenevolesOuContacts");
		
		JPanel panelMateriel = new ListeBenevoles();
		this.panneauPrincipal.add(panelMateriel, "listeMateriel");
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanneauPrincipal() {
		return panneauPrincipal;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

}
