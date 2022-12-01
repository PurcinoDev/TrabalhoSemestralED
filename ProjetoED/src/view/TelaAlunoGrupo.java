package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controller.GrupoTCCController;
import enumeracoes.Fonte;
import model.GrupoTCC;

public class TelaAlunoGrupo extends JFrame {

	private JPanel contentPane;
	public static GrupoTCC grupo;

	public TelaAlunoGrupo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 204);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(new Color(187, 187, 187));
		panel.setBounds(0, 0, 800, 38);
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
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAlunoCadGrupo cadGrupo = new TelaAlunoCadGrupo();
				cadGrupo.editar(grupo);
				cadGrupo.setVisible(true);
				setVisible(false);
			}
		});
		final String CUR_DIR_IMAGE1 = System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "images" + File.separator;
		lblNewLabel_2.setIcon(new ImageIcon(CUR_DIR_IMAGE1 + "Vector.png"));
		lblNewLabel_2.setBounds(610, 5, 32, 32);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String CUR_DIR_RESOURCE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources";
				
				try {
					GrupoTCCController controller = new GrupoTCCController();
					controller.removerGrupo(grupo.nome, CUR_DIR_RESOURCE, "grupoTCC.csv");
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
				grupo = null;
				
				TelaAluno telaAluno = new TelaAluno();
				telaAluno.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(CUR_DIR_IMAGE1 + "Vector-1.png"));
		lblNewLabel_3.setBounds(647, 5, 20, 32);
		panel_1.add(lblNewLabel_3);
	}
}