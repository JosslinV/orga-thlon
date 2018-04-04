package rocher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
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
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnCourses = new GridBagConstraints();
		gbc_btnCourses.insets = new Insets(0, 0, 5, 0);
		gbc_btnCourses.gridx = 0;
		gbc_btnCourses.gridy = 0;
		BandeauGauche.add(btnCourses, gbc_btnCourses);
		
		btnContacts = new JButton("Contacts");
		GridBagConstraints gbc_btnContacts = new GridBagConstraints();
		gbc_btnContacts.insets = new Insets(0, 0, 5, 0);
		gbc_btnContacts.gridx = 0;
		gbc_btnContacts.gridy = 1;
		BandeauGauche.add(btnContacts, gbc_btnContacts);
		
		JButton btnMateriel = new JButton("Materiel");
		btnMateriel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnMateriel = new GridBagConstraints();
		gbc_btnMateriel.gridx = 0;
		gbc_btnMateriel.gridy = 2;
		BandeauGauche.add(btnMateriel, gbc_btnMateriel);
		
		JPanel PanneauPrincipal = new JPanel();
		contentPane.add(PanneauPrincipal, BorderLayout.CENTER);
		PanneauPrincipal.setLayout(new CardLayout(0, 0));
		
		JPanel pannelCourses = new JPanel();
		PanneauPrincipal.add(pannelCourses, "name_1617294281113403");
		
		JPanel panelContacts = new JPanel();
		PanneauPrincipal.add(panelContacts, "name_1617419290050600");
		
		JPanel panelMateriel = new JPanel();
		PanneauPrincipal.add(panelMateriel, "name_1617710038479744");
	}

}
