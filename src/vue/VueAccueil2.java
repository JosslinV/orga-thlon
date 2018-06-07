package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.RequestDataBase.RequestMateriel;
import controleur.ControleurGeneral;
import modele.Materiel;
import rocher.FenetreAccueil;
import rocher.ListeGenerique;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
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
					RequestMateriel reqMat = new RequestMateriel();
					ArrayList<Materiel> materiels;
				
						materiels = reqMat.requestAll();
						ArrayList<Object>aom = new ArrayList<Object>() ;
						for (Materiel mat : materiels) {
							aom.add(mat);
						}
					
					VueAccueil2 frame = new VueAccueil2(aom);
					frame.setVisible(true);
					frame.setTitle("Orgathlon");
					
					}catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();	
					
					
					}
				
				}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueAccueil2(ArrayList<Object> aom) throws Exception{
		ControleurGeneral controleur = new ControleurGeneral(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
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
		
		JPanel panelMateriel = new ListeGenerique(aom);
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
