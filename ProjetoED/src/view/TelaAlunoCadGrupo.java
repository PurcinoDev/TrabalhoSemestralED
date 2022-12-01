package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.ControllerCadastro;
import controller.GrupoTCCController;
import controller.Tipo;
import enumeracoes.Fonte;
import model.GrupoTCC;

public class TelaAlunoCadGrupo extends JFrame {

	private JPanel contentPane;
	private JPanel panelModal;
	private JTextField tfNomeGrupo;
	private JComboBox<String> comboModalidadeGrupo;
	private JComboBox<String> comboOrientador;
	private JTextField tfTemaGrupo;
	private JList<String> list;
	private JButton btnSalvarGrupo;
	private JButton btnCancelarGrupo;
	
	private ControllerCadastro contCad = new ControllerCadastro();
	
	private boolean editar = false;
	
	public TelaAlunoCadGrupo() {
		final String CUR_DIR_RESOURCE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources";
		editar = false;
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(74, 74, 74, 125));
		panel_1.setBounds(0, 0, 509, 500);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panelModal = new JPanel();
		panelModal.setBounds(92, 11, 349, 346);
		panelModal.setBackground(new Color(255, 255, 255));
		panel_1.add(panelModal);
		panelModal.setLayout(null);
		
		DefaultListModel<String> dml = new DefaultListModel<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 196, 320, 60);
		panelModal.add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBorder(new MatteBorder(1, 1, 1, 1, new Color(128, 128, 128)));
		list.setBackground(new Color(212, 212, 212));
		
		String[] array = null;
		try {
			array = contCad.fileToList(Tipo.ALUNO, CUR_DIR_RESOURCE, "aluno.csv");
			int aux = array != null ? array.length : 0;
			for (int i = 0; i < aux; i++) {
				String aux1 = array[i];
				dml.addElement(aux1);
			}
			list.setModel(dml);
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
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
		
		String[] modalidades = null;
		try { 
			modalidades = contCad.fileToList(Tipo.MODALIDADE, CUR_DIR_RESOURCE, "modalidade.csv");
		} 
		catch (Exception e1) {
			e1.printStackTrace();
			modalidades = new String[] {"Selecione..."};
		}
		
		comboModalidadeGrupo.setModel(new DefaultComboBoxModel<>(modalidades));
		comboModalidadeGrupo.setBounds(10, 103, 329, 20);
		panelModal.add(comboModalidadeGrupo);

		comboOrientador = new JComboBox<>();
		
		String[] professores = null;
		try { 
			professores = contCad.fileToList(Tipo.PROFESSOR, CUR_DIR_RESOURCE, "professor.csv");
		} 
		catch (Exception e1) {
			e1.printStackTrace();
			professores = new String[] {"Selecione..."};
		}
		
		comboOrientador.setModel(new DefaultComboBoxModel<>(professores));
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
		
		botaoCancelar();
		botaoSalvar(list, CUR_DIR_RESOURCE);
	}

	private void botaoSalvar(JList<String> list, String caminho) {
		btnSalvarGrupo = new JButton("Salvar");
		btnSalvarGrupo.addActionListener((ActionEvent e) -> {
			
			if (tfNomeGrupo.getText().isEmpty()
					|| comboModalidadeGrupo.getSelectedItem() == "Selecione..."
					|| comboOrientador.getSelectedItem() == "Selecione...") {
				
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos de cadastro do TCC!", "Erro", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				GrupoTCC grupoTCC = new GrupoTCC();
				grupoTCC.nome = tfNomeGrupo.getText();
				grupoTCC.modalidade = (String) comboModalidadeGrupo.getSelectedItem();
				grupoTCC.professor = (String) comboOrientador.getSelectedItem();
				
				List<String> integrantes = list.getSelectedValuesList();
				final int QUANTIDADE_INTEGRANTES = integrantes.size();
				String[] nomeIntegrantesTemp = new String[QUANTIDADE_INTEGRANTES];
				for (int i=0; i<QUANTIDADE_INTEGRANTES; i++) {
					nomeIntegrantesTemp[i] = integrantes.get(i);
				}
				
				grupoTCC.nomeIntegrantes = nomeIntegrantesTemp;
				grupoTCC.tema = tfTemaGrupo.getText();
				
				try {
					GrupoTCCController controller = new GrupoTCCController();
					
					if (editar == false) {
						controller.criaGrupo(grupoTCC, caminho, "grupoTCC.csv");
					}
					else {
						controller.alteraGrupo(grupoTCC, caminho, "grupoTCC.csv");
					}
				} 
				catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
				
				TelaAlunoGrupo.grupo = grupoTCC;
				TelaAlunoGrupo grupo = new TelaAlunoGrupo();
				grupo.setVisible(true);
				setVisible(false);
			}
		});
		btnSalvarGrupo.setBounds(180, 312, 160, 24);
		panelModal.add(btnSalvarGrupo);
	}

	private void botaoCancelar() {
		btnCancelarGrupo = new JButton("Cancelar");
		
		btnCancelarGrupo.addActionListener((ActionEvent e) -> {
			TelaAluno aluno = new TelaAluno();
			aluno.setVisible(true);
			setVisible(false);
		});
		
		btnCancelarGrupo.setBounds(10, 312, 160, 24);
		panelModal.add(btnCancelarGrupo);
	}

	public void editar(GrupoTCC grupo) {
		tfNomeGrupo.setText(grupo.nome);
		comboModalidadeGrupo.setSelectedItem(grupo.modalidade);
		comboOrientador.setSelectedItem(grupo.professor);
		list.setListData(grupo.nomeIntegrantes);
		list.setEnabled(false);
		tfTemaGrupo.setText(grupo.tema);
		btnCancelarGrupo.setEnabled(false);
		
		editar = true;
	}
}