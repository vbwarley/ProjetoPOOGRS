package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class InterfaceGU extends JFrame {

	private JPanel contentPane;
	private JTextField nomeText;
	private JTextField senhaText;
	private JPanel painelLogin;
	private JTextField nomeCadastroText;
	private JTextField senhaCadastroText;
	private JTextField textField;
	private JPanel painelCadastrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGU frame = new InterfaceGU();
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
	public InterfaceGU() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField = new JTextField();
		painelCadastrar.add(textField, "cell 1 2,alignx center");
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		painelCadastrar.add(btnCadastrar, "cell 1 3,alignx center");
		
		contentPane.add(painelCadastrar, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
}
