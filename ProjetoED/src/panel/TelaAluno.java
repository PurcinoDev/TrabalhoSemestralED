package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import panel.enumeracoes.Fonte;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	
	public TelaAluno() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 353);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSemGrupo = new JLabel("Voc\u00EA n\u00E3o tem grupo");
		lblSemGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemGrupo.setFont(new Font(Fonte.ARIAL.getFonte(), Font.PLAIN, 18));
		lblSemGrupo.setBounds(135, 67, 211, 31);
		contentPane.add(lblSemGrupo);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(new Color(187, 187, 187));
		panel.setBounds(0, 0, 493, 38);
		contentPane.add(panel);
		
		JLabel lblIntroducao = new JLabel(" Introdu\u00E7\u00E3o");
		lblIntroducao.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntroducao.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblIntroducao);
		lblIntroducao.setBackground(new Color(187, 187, 187));
		lblIntroducao.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 24));
		
		JButton btnNewButton = new JButton("Clique aqui e crie seu grupo");
		btnNewButton.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		btnNewButton.addActionListener((ActionEvent e) -> {
			TelaAlunoCadGrupo modalAluno = new TelaAlunoCadGrupo();
			modalAluno.setVisible(true);
			setVisible(false);
		});
		btnNewButton.setBounds(43, 107, 423, 134);
		contentPane.add(btnNewButton);
	}
}