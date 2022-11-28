package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import panel.enumeracoes.Fonte;

public class TelaAlunoGrupo extends JFrame {

	private JPanel contentPane;

	public TelaAlunoGrupo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 727);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(new Color(187, 187, 187));
		panel.setBounds(0, 0, 752, 38);
		contentPane.add(panel);
		
		JLabel lblIntroducao = new JLabel(" Introdu\u00E7\u00E3o");
		lblIntroducao.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntroducao.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblIntroducao);
		lblIntroducao.setBackground(new Color(187, 187, 187));
		lblIntroducao.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 24));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(43, 53, 677, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAcompanharDesenv = new JLabel("Acompanhe aqui o seu desenvolvimento:");
		lblAcompanharDesenv.setBounds(5, 5, 228, 13);
		panel_1.add(lblAcompanharDesenv);
		lblAcompanharDesenv.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 11));
		
		JProgressBar progressDesenv = new JProgressBar();
		progressDesenv.setValue(20);
		progressDesenv.setBounds(5, 36, 662, 24);
		progressDesenv.setBackground(new Color(255, 255, 255));
		progressDesenv.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		progressDesenv.setForeground(new Color(255, 0, 0));
		panel_1.add(progressDesenv);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\felip\\OneDrive\\Imagens\\edit.png"));
		lblNewLabel_2.setBounds(610, 5, 32, 32);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\felip\\OneDrive\\Imagens\\delete.png"));
		lblNewLabel_3.setBounds(647, 5, 20, 32);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Atividades Pendentes");
		lblNewLabel.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 14));
		lblNewLabel.setBounds(43, 169, 677, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(43, 194, 677, 155);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panelReport = new JPanel();
		panelReport.setBackground(new Color(198, 198, 198));
		panelReport.setBounds(0, 0, 677, 32);
		panel_2.add(panelReport);
		panelReport.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Report Inicial - Debate da ideia do TCC");
		lblNewLabel_1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 10, 226, 14);
		panelReport.add(lblNewLabel_1);
		
		JLabel lblAtividadesRealizadas = new JLabel("Atividades Realizadas");
		lblAtividadesRealizadas.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 14));
		lblAtividadesRealizadas.setBounds(43, 360, 677, 14);
		contentPane.add(lblAtividadesRealizadas);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(43, 385, 677, 155);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panelReport_1 = new JPanel();
		panelReport_1.setBackground(new Color(198, 198, 198));
		panelReport_1.setBounds(0, 0, 677, 32);
		panel_2_1.add(panelReport_1);
		panelReport_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Report Inicial - Debate da ideia do TCC");
		lblNewLabel_1_1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 11, 255, 14);
		panelReport_1.add(lblNewLabel_1_1);
	}
}