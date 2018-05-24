package rocher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JButton btnContacts;

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
	public VueAccueil2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel BandeauGauche = new JPanel();
		contentPane.add(BandeauGauche, BorderLayout.WEST);
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
		
		btnContacts = new JButton();
		btnContacts.setIcon(new ImageIcon("./src/RessourcesImages/equipe.png","ImgContacts"));
		GridBagConstraints gbc_btnContacts = new GridBagConstraints();
		gbc_btnContacts.insets = new Insets(0, 0, 5, 0);
		gbc_btnContacts.gridx = 0;
		gbc_btnContacts.gridy = 1;
		BandeauGauche.add(btnContacts, gbc_btnContacts);
		
		JButton btnMateriel = new JButton();
		btnMateriel.setIcon(new ImageIcon("./src/RessourcesImages/Shape-Cube-128.png","ImgMateriel"));
		GridBagConstraints gbc_btnMateriel = new GridBagConstraints();
		gbc_btnMateriel.gridx = 0;
		gbc_btnMateriel.gridy = 2;
		BandeauGauche.add(btnMateriel, gbc_btnMateriel);
		
		JPanel PanneauPrincipal = new JPanel();
		contentPane.add(PanneauPrincipal, BorderLayout.CENTER);
		PanneauPrincipal.setLayout(new CardLayout(0, 0));
		
		JPanel pannelCourses = new VueOnglets();
		PanneauPrincipal.add(pannelCourses, "TableauKanban");
		
		JPanel panelContacts = new BenevolesOuContacts2();
		PanneauPrincipal.add(panelContacts, "BenevolesOuContacts");
		
		JPanel panelMateriel = new ListeBenevoles();
		PanneauPrincipal.add(panelMateriel, "listeMateriel");
	}

}
