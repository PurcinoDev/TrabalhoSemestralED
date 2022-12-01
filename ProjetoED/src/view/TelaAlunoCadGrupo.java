package view;

import model.Aluno;
import model.GrupoTCC;
import controller.ControllerCadastro;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import enumeracoes.Fonte;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;

public class TelaAlunoCadGrupo extends JFrame {

	private JPanel contentPane;
	private JPanel panelModal;
	private JTextField tfNomeGrupo;
	private JComboBox<String> comboModalidadeGrupo;
	private JComboBox<String> comboOrientador;
	private JTextField tfTemaGrupo;
	private JList list;
	ControllerCadastro contCad = new ControllerCadastro();

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
		panel_1.setBounds(0, 0, 538, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panelModal = new JPanel();
		panelModal.setBounds(92, 11, 349, 346);
		panelModal.setBackground(new Color(255, 255, 255));
		panel_1.add(panelModal);
		panelModal.setLayout(null);

		DefaultListModel DLM = new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 196, 240, 48);
		panelModal.add(scrollPane);
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		list.setBackground(new Color(212, 212, 212));

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
		comboModalidadeGrupo.setModel(new DefaultComboBoxModel<>(
				new String[] { "=========== Escolha sua Modalidade ===========", "Software", "Artigo", "Monografia" }));
		comboModalidadeGrupo.setBounds(10, 103, 329, 20);
		panelModal.add(comboModalidadeGrupo);

		comboOrientador = new JComboBox<>();
		comboOrientador
				.setModel(new DefaultComboBoxModel<>(new String[] { "=========== Escolha seu Orientador ===========",
						"Leandro Colevati", "Cristina Correa", "Wellington Pinto" }));
		comboOrientador.setBounds(10, 150, 329, 20);
		panelModal.add(comboOrientador);

		JLabel lblProfessorOrientador = new JLabel("Professor Orientador");
		lblProfessorOrientador.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblProfessorOrientador.setBounds(10, 134, 158, 14);
		panelModal.add(lblProfessorOrientador);

		JLabel lblModalidadeGrupo_1_1 = new JLabel("Nome dos Integrantes");
		lblModalidadeGrupo_1_1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblModalidadeGrupo_1_1.setBounds(10, 181, 158, 14);
		panelModal.add(lblModalidadeGrupo_1_1);

		tfTemaGrupo = new JTextField();
		tfTemaGrupo.setColumns(10);
		tfTemaGrupo.setBounds(10, 281, 329, 20);
		panelModal.add(tfTemaGrupo);

		JLabel lblModalidadeGrupo_1_1_1 = new JLabel("Tema do projeto");
		lblModalidadeGrupo_1_1_1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblModalidadeGrupo_1_1_1.setBounds(10, 265, 158, 14);
		panelModal.add(lblModalidadeGrupo_1_1_1);

//================================================== BOTÃO DE CANCELAR ==================================================
		JButton btnCancelarGrupo = new JButton("CANCELAR");
		btnCancelarGrupo.addActionListener((ActionEvent e) -> {
			TelaAluno aluno = new TelaAluno();
			aluno.setVisible(true);
			setVisible(false);
		});
		btnCancelarGrupo.setBounds(10, 312, 86, 23);
		panelModal.add(btnCancelarGrupo);

//=================================================== BOTÃO DE SALVAR ===================================================
		JButton btnSalvarGrupo = new JButton("SALVAR");
		btnSalvarGrupo.addActionListener((ActionEvent e) -> {
			if (tfNomeGrupo.getText().isEmpty()
					|| comboModalidadeGrupo.getSelectedItem() == "=========== Escolha sua Modalidade ==========="
					|| comboOrientador.getSelectedItem() == "=========== Escolha seu Orientador ===========") {
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos de cadastro do TCC");
			} else {
				GrupoTCC grupoTCC = new GrupoTCC();
				grupoTCC.nome = tfNomeGrupo.getText();
				grupoTCC.modalidade = (String) comboModalidadeGrupo.getSelectedItem();
				grupoTCC.Professor = (String) comboOrientador.getSelectedItem();
//				grupoTCC.nomeIntegrantes = (String) list.getSelectedValue();
				grupoTCC.tema = tfTemaGrupo.getText();
				TelaAlunoGrupo grupo = new TelaAlunoGrupo();
				grupo.setVisible(true);
				setVisible(false);
			}
		});
		btnSalvarGrupo.setBounds(253, 312, 86, 23);
		panelModal.add(btnSalvarGrupo);

//================================================== BOTÃO DE ATUALIZAR ==================================================
		JButton btnAtualizarAlunos = new JButton("Atualizar Alunos");
		btnAtualizarAlunos.addActionListener((ActionEvent e) -> {
			String[] array;
			try {
				array = contCad.fileToList("aluno", "C:\\Users"
						+ "\\felip\\Downloads\\TrabalhoSemestralED-main\\TrabalhoSemestralED-main"
						+ "\\ProjetoED\\src\\resources", "AlunosGeral.csv");
				int aux = array.length;
				for (int i = 0; i < aux; i++) {
					String aux1 = array[i];
					DLM.addElement(aux1);
				}
				list.setModel(DLM);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btnAtualizarAlunos.setBounds(120, 312, 111, 23);
		panelModal.add(btnAtualizarAlunos);
		
		JButton btnAdicionarIntegrante = new JButton("Adicionar");
		btnAdicionarIntegrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null) {
					String[] integrantes = (String[]) list.getSelectedValue();
				
					
					int tamanho = integrantes.length > 0 ? integrantes.length : null;

					DLM.removeElement(integrantes[tamanho - 1]);
				}
				
			}
		});
		btnAdicionarIntegrante.setBounds(253, 209, 89, 23);
		panelModal.add(btnAdicionarIntegrante);

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
