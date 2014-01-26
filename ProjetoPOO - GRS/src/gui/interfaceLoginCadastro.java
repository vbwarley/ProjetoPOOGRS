package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JSplitPane;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.CardLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

public class interfaceLoginCadastro extends JFrame {

	//Butões
	//Paineis
	private JPanel contentPane;
	private JPanel painelLogin;
	private JPanel painelCadastrar;
	
	//Campos de texto
	private JTextField nomeText;
	private JTextField senhaText;
	private JTextField nomeCadastroText;
	private JTextField senhaCadastroText;
	private JTextField departamentoCadastroText;
	
	//ComboBoxes
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceLoginCadastro frame = new interfaceLoginCadastro();
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
	public interfaceLoginCadastro() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SGRS - DourLey");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (painelCadastrar != null){
					painelCadastrar.setVisible(false);
				} 
				
				painelLogin();
				
			}
		});
		
		toolBar.add(btnLogin);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelLogin != null){
					painelLogin.setVisible(false);
				}
				
				painelCadastro();
			}
		});
		toolBar.add(btnCadastro);
		
		
		painelLogin = new JPanel();
		
	}
	
	public void painelLogin(){
		
		painelLogin = new JPanel();
		
		painelLogin.setLayout(new MigLayout("", "[114px][][49px]", "[19px][15px][]"));
		
		JLabel lblNome = new JLabel("Nome: ");
		painelLogin.add(lblNome, "flowx,cell 0 0,alignx center,aligny center");
		
		nomeText = new JTextField();
		painelLogin.add(nomeText, "flowy,cell 1 0,alignx left,aligny top");
		nomeText.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		painelLogin.add(lblSenha, "cell 0 1,alignx center,aligny top");
		
		senhaText = new JTextField();
		painelLogin.add(senhaText, "cell 1 1,alignx left,aligny top");
		senhaText.setColumns(10);
		
		JButton btnAutenticar = new JButton("Autenticar");
		painelLogin.add(btnAutenticar, "cell 1 2");
		btnAutenticar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Aqui se divide quem é cliente e quem é administrador
				int tipoUsuario = InterfaceUsuario.autenticacao(nomeText.getText(), senhaText.getText());
				
				if (tipoUsuario == 1) {
					InterfaceDeAdministrador.executar(tipoUsuario);
					System.exit(0);
				} else if (tipoUsuario >= 2){
					InterfaseDeCliente.executar(tipoUsuario);
					System.exit(0);
				}
				
			}
		});
		
		contentPane.add(painelLogin, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
	public void painelCadastro(){
		
		painelCadastrar = new JPanel();
		
		contentPane.add(painelCadastrar, BorderLayout.CENTER);
		painelCadastrar.setLayout(new MigLayout("", "[114px][grow][grow][grow]", "[19px][][][]"));
		
		JLabel lblNome_1 = new JLabel("Nome: ");
		painelCadastrar.add(lblNome_1, "cell 0 0,alignx center");
		
		nomeCadastroText = new JTextField();
		painelCadastrar.add(nomeCadastroText, "cell 1 0,alignx center");
		nomeCadastroText.setColumns(10);
		
		JLabel lblSenha_1 = new JLabel("Senha:");
		painelCadastrar.add(lblSenha_1, "cell 0 1,alignx center");
		
		senhaCadastroText = new JTextField();
		painelCadastrar.add(senhaCadastroText, "cell 1 1,alignx center,aligny center");
		senhaCadastroText.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		painelCadastrar.add(lblDepartamento, "cell 0 2,alignx trailing");
		
		departamentoCadastroText = new JTextField();
		painelCadastrar.add(departamentoCadastroText , "cell 1 2,alignx center");
		departamentoCadastroText.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		painelCadastrar.add(btnCadastrar, "cell 1 3,alignx center");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				InterfaceUsuario.criarUsuario(nomeCadastroText.getText(), departamentoCadastroText.getText(), senhaCadastroText.getText());
				
			}
		});
		
		contentPane.add(painelCadastrar, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
}
