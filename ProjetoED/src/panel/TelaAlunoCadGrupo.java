package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import panel.enumeracoes.Fonte;

public class TelaAlunoCadGrupo extends JFrame {

	private JPanel contentPane;
	private JPanel panelModal;
	private JTextField tfNomeGrupo;
	private JComboBox<String> comboModalidadeGrupo;
	private JComboBox<String> comboOrientador;
	private JTextField textField_1;
	private JTextField tfTemaGrupo;

	public TelaAlunoCadGrupo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 407);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(74, 74, 74, 125));
		panel_1.setBounds(0, 0, 602, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panelModal = new JPanel();
		panelModal.setBounds(92, 11, 349, 346);
		panelModal.setBackground(new Color(255, 255, 255));
		panel_1.add(panelModal);
		panelModal.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crie seu grupo de TCC");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 16));
		lblNewLabel.setBounds(87, 11, 190, 20);
		panelModal.add(lblNewLabel);
		
		JLabel lblNomeGrupo = new JLabel("Nome do grupo");
		lblNomeGrupo.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblNomeGrupo.setBounds(10, 36, 86, 14);
		lblNomeGrupo.setAlignmentX(2.0f);
		panelModal.add(lblNomeGrupo);
		
		tfNomeGrupo = new JTextField();
		tfNomeGrupo.setBounds(10, 55, 329, 20);
		panelModal.add(tfNomeGrupo);
		tfNomeGrupo.setColumns(10);
		
		JLabel lblModalidadeGrupo = new JLabel("Modalidades do projeto");
		lblModalidadeGrupo.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblModalidadeGrupo.setBounds(10, 87, 158, 14);
		panelModal.add(lblModalidadeGrupo);
		
		comboModalidadeGrupo = new JComboBox<>();
		comboModalidadeGrupo.setModel(new DefaultComboBoxModel<>(new String[] {"Software", "Artigo", "Monografia"}));
		comboModalidadeGrupo.setBounds(10, 103, 329, 20);
		panelModal.add(comboModalidadeGrupo);
		
		comboOrientador = new JComboBox<>();
		comboOrientador.setBounds(10, 150, 329, 20);
		panelModal.add(comboOrientador);
		
		JLabel lblProfessorOrientador = new JLabel("Professor Orientador");
		lblProfessorOrientador.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblProfessorOrientador.setBounds(10, 134, 158, 14);
		panelModal.add(lblProfessorOrientador);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 197, 329, 20);
		panelModal.add(textField_1);
		
		JLabel lblModalidadeGrupo_1_1 = new JLabel("Nome dos Integrantes");
		lblModalidadeGrupo_1_1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblModalidadeGrupo_1_1.setBounds(10, 181, 158, 14);
		panelModal.add(lblModalidadeGrupo_1_1);
		
		tfTemaGrupo = new JTextField();
		tfTemaGrupo.setColumns(10);
		tfTemaGrupo.setBounds(10, 264, 329, 20);
		panelModal.add(tfTemaGrupo);
		
		JLabel lblModalidadeGrupo_1_1_1 = new JLabel("Tema do projeto");
		lblModalidadeGrupo_1_1_1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblModalidadeGrupo_1_1_1.setBounds(10, 248, 158, 14);
		panelModal.add(lblModalidadeGrupo_1_1_1);
		
		JButton btnCancelarGrupo = new JButton("CANCELAR");
		btnCancelarGrupo.setBounds(34, 312, 118, 23);
		panelModal.add(btnCancelarGrupo);
		
		JButton btnSalvarGrupo = new JButton("SALVAR");
		btnSalvarGrupo.addActionListener((ActionEvent e) -> {
			TelaAlunoGrupo grupo = new TelaAlunoGrupo();
			grupo.setVisible(true);
			setVisible(false);
		});
		btnSalvarGrupo.setBounds(186, 312, 118, 23);
		panelModal.add(btnSalvarGrupo);
		
		JLabel lblSemGrupo = new JLabel("Voc\u00EA n\u00E3o tem grupo");
		lblSemGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemGrupo.setFont(new Font(Fonte.ARIAL.getFonte(), Font.PLAIN, 18));
		lblSemGrupo.setBounds(135, 67, 212, 31);
		contentPane.add(lblSemGrupo);
		
		JButton btnNewButton = new JButton("Clique aqui e crie seu grupo");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		btnNewButton.setBounds(43, 107, 423, 134);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(new Color(187, 187, 187));
		panel.setBounds(0, 0, 602, 38);
		contentPane.add(panel);
		
		JLabel lblIntroducao = new JLabel(" Introdu\u00E7\u00E3o");
		lblIntroducao.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntroducao.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblIntroducao);
		lblIntroducao.setBackground(new Color(187, 187, 187));
		lblIntroducao.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 24));
	}
}