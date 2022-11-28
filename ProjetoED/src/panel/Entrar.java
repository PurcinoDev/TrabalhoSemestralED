package panel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import panel.enumeracoes.Fonte;

public class Entrar extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	
	private static Entrar entrar = new Entrar();
	private JPasswordField tfSenha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				entrar.setVisible(true);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public Entrar() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 353);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(267, 115, 159, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblEntrar = new JLabel("ENTRAR");
		lblEntrar.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 32));
		lblEntrar.setBounds(33, 79, 146, 46);
		contentPane.add(lblEntrar);
		
		JLabel lblMensagemExpo1 = new JLabel("Entre e/ou cadastre seu TCC");
		lblMensagemExpo1.setFont(new Font(Fonte.ARIAL.getFonte(), Font.PLAIN, 10));
		lblMensagemExpo1.setBounds(33, 136, 159, 20);
		contentPane.add(lblMensagemExpo1);
		
		JLabel lblMensagemExpo2 = new JLabel("em nossa base de dados");
		lblMensagemExpo2.setFont(new Font(Fonte.ARIAL.getFonte(), Font.PLAIN, 10));
		lblMensagemExpo2.setBounds(33, 154, 146, 14);
		contentPane.add(lblMensagemExpo2);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 11));
		btnEntrar.addActionListener((ActionEvent e) -> {
			TelaAluno aluno = new TelaAluno();
			aluno.setVisible(true);
			entrar.setVisible(false);
		});
		btnEntrar.setBounds(236, 223, 118, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblUsuario = new JLabel("USU\u00C1RIO");
		lblUsuario.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblUsuario.setBounds(267, 102, 59, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("SENHA");
		lblNewLabel.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		lblNewLabel.setBounds(267, 154, 46, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 244, 244));
		panel.setBounds(0, 0, 219, 314);
		contentPane.add(panel);
		
		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 12));
		tfSenha.setBounds(267, 169, 159, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font(Fonte.ARIAL.getFonte(), Font.BOLD, 11));
		btnNewButton.setBounds(365, 223, 118, 23);
		contentPane.add(btnNewButton);
	}
}