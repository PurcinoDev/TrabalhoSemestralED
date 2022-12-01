package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import enumeracoes.Fonte;

public class TelaProfessor extends JFrame {

	private JPanel contentPane;

	public TelaProfessor() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 266);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 47);
		panel.setBackground(new Color(187, 187, 187));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTccsSolicitantes = new JLabel("TCC's solicitantes");
		lblTccsSolicitantes.setBounds(10, 11, 220, 28);
		panel.add(lblTccsSolicitantes);
		lblTccsSolicitantes.setVerticalAlignment(SwingConstants.TOP);
		lblTccsSolicitantes.setHorizontalAlignment(SwingConstants.LEFT);
		lblTccsSolicitantes.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 24));
		lblTccsSolicitantes.setBackground(new Color(187, 187, 187));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		panel_1.setBounds(10, 77, 415, 78);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Grupo s\u00E9rio de Trabalho");
		lblNewLabel.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 219, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnRecusar = new JButton("RECUSAR");
		btnRecusar.setFont(new Font("Arial", Font.BOLD, 11));
		btnRecusar.setBounds(10, 36, 118, 23);
		panel_1.add(btnRecusar);
		
		JButton btnAceitar = new JButton("ACEITAR");
		btnAceitar.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 11));
		btnAceitar.setBounds(138, 36, 118, 23);
		panel_1.add(btnAceitar);
		
		JLabel lblNewLabel_1 = new JLabel("03/05/2022");
		lblNewLabel_1.setBounds(333, 12, 82, 14);
		panel_1.add(lblNewLabel_1);
	}
}