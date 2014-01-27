package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.FlowLayout;

public class InterfaceDeAdministrador extends JFrame {

	private JPanel painelPrincipal;
	private JTextField nomeText;
	private JTextField senhaText;
	private JTextField departamentoText;
	private JPanel painelCriarUsuario;
	private JPanel painelManterUsuarios;
	private JTextField nomeConsultarText;
	private JPanel painelConsultarUsuarios;
	private JTextField codigoExcluirText;
	private JPanel painelExcluirUsuario;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPanel painelAtualizarUsuario;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPanel painelManterRequisicao;
	private JPanel painelEnviarRequisicao;
	private JTextField textField_11;
	private JPanel painelConsultarRequisicao;

	private static int codigoUsuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		//codigoUsuario = codigo;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeAdministrador frame = new InterfaceDeAdministrador();
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
	public InterfaceDeAdministrador() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(BorderFactory.createTitledBorder("Menu"));
		painelPrincipal.setLayout(new GridBagLayout());
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;

		JButton btnManterUsuario = new JButton("Manter usuarios");
		btnManterUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelManterRequisicao != null){
					painelManterRequisicao.setVisible(false);
				} 
				
				painelPrincipal.setVisible(false);
				
				painelManterUsuarios();
			}
		});
		painelPrincipal.add(btnManterUsuario, grid);

		
		grid.gridx = 1;
		grid.gridy = 0;
		JButton btnManterRequisio = new JButton("Manter requisições");
		btnManterRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelManterUsuarios != null){
					painelManterUsuarios.setVisible(false);
				} 
				
				painelPrincipal.setVisible(false);
				painelManterRequisicao();
			}
		});
		painelPrincipal.add(btnManterRequisio, grid);

		this.add(BorderLayout.BEFORE_FIRST_LINE, painelPrincipal);
						
	}
	
	public void painelManterUsuarios(){

		painelManterUsuarios = new JPanel();
		painelManterUsuarios.setBorder(BorderFactory.createTitledBorder("Manter usuarios"));
		painelManterUsuarios.setLayout(new GridBagLayout());
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);

		grid.gridx = 0;
		grid.gridy = 0;

		JButton btnCriarUsuario = new JButton("Criar usuario");
		btnCriarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelAtualizarUsuario != null){
					painelAtualizarUsuario.setVisible(false);
				} if (painelConsultarUsuarios != null) {
					painelConsultarUsuarios.setVisible(false);
				} if (painelExcluirUsuario != null){
					painelExcluirUsuario.setVisible(false);
				} 
				
				painelManterUsuarios.setVisible(false);
				painelCriarUsuario();

			}
		});
		painelManterUsuarios.add(btnCriarUsuario, grid);

		grid.gridx = 1;
		grid.gridy = 0;
		
		JButton btnNewButton = new JButton("Consultar usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelAtualizarUsuario != null){
					painelAtualizarUsuario.setVisible(false);
				} if (painelCriarUsuario != null) {
					painelCriarUsuario.setVisible(false);
				} if (painelExcluirUsuario != null){
					painelExcluirUsuario.setVisible(false);
				} 
				
				painelManterUsuarios.setVisible(false);
				painelConsultarUsuarios();			
			}
		});
		
		painelManterUsuarios.add(btnNewButton, grid);

		JButton btnAlterarUsuario = new JButton("Excluir usuario");
		btnAlterarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelAtualizarUsuario != null){
					painelAtualizarUsuario.setVisible(false);
				} if (painelCriarUsuario != null) {
					painelCriarUsuario.setVisible(false);
				} if (painelConsultarUsuarios != null){
					painelConsultarUsuarios.setVisible(false);
				} 
				
				painelManterUsuarios.setVisible(false);
				painelExcluirUsuario();
				
			}
		});
		
		grid.gridx = 0;
		grid.gridy = 1;
		
		painelManterUsuarios.add(btnAlterarUsuario, grid);

		JButton btnAtualizarUsuario = new JButton("Atualizar usuario");
		btnAtualizarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (painelExcluirUsuario != null){
					painelExcluirUsuario.setVisible(false);
				} if (painelCriarUsuario != null) {
					painelCriarUsuario.setVisible(false);
				} if (painelConsultarUsuarios != null){
					painelConsultarUsuarios.setVisible(false);
				} 
				
				painelManterUsuarios.setVisible(false);
				painelAtualizarUsuario();
				
			}
		});
		
		grid.gridx = 1;
		grid.gridy = 1;
		
		painelManterUsuarios.add(btnAtualizarUsuario, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelManterUsuarios);
		
		
	}

	public void painelCriarUsuario(){

		painelCriarUsuario = new JPanel();
		painelCriarUsuario.setBorder(BorderFactory.createTitledBorder("Criar usuário"));
		painelCriarUsuario.setLayout(new GridBagLayout());

		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 2;
		
		JLabel lblNome = new JLabel("Nome: ");
		painelCriarUsuario.add(lblNome, grid);

		grid.gridx = 1;
		grid.gridy = 2;
		nomeText = new JTextField();
		painelCriarUsuario.add(nomeText, grid);
		nomeText.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 3;	
		JLabel lblSenha = new JLabel("Senha: ");
		painelCriarUsuario.add(lblSenha, grid);

		grid.gridx = 1;
		grid.gridy = 3;
		senhaText = new JTextField();
		painelCriarUsuario.add(senhaText, grid);
		senhaText.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 4;
		JLabel lblDepartamento = new JLabel("Departamento:");
		painelCriarUsuario.add(lblDepartamento, grid);

		grid.gridx = 1;
		grid.gridy = 4;
		departamentoText = new JTextField();
		painelCriarUsuario.add(departamentoText, grid);
		departamentoText.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 5;
		JButton botaoCriarUsuario = new JButton("Criar");
		painelCriarUsuario.add(botaoCriarUsuario, grid);
		botaoCriarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InterfaceUsuario.criarUsuario(nomeText.getText(), departamentoText.getText(), senhaText.getText());
				
			}
		});

		this.add(BorderLayout.BEFORE_FIRST_LINE, painelCriarUsuario);
	}

	public void painelConsultarUsuarios(){

		painelConsultarUsuarios = new JPanel();
		painelConsultarUsuarios.setBorder(BorderFactory.createTitledBorder("Consultar usuários"));
		painelConsultarUsuarios.setLayout(new GridBagLayout());

		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JLabel lblNome_1 = new JLabel("Nome: ");
		painelConsultarUsuarios.add(lblNome_1, grid);

		grid.gridx = 1;
		grid.gridy = 0;
		nomeConsultarText = new JTextField();
		painelConsultarUsuarios.add(nomeConsultarText, grid);
		nomeConsultarText.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 1;
		JButton botaoConsultar = new JButton("Consultar");
		painelConsultarUsuarios.add(botaoConsultar, grid);
		botaoConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InterfaceUsuario.consultarUsuario(nomeConsultarText.getText());
				
			}
		});

		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarUsuarios);
		
	}

	public void painelExcluirUsuario(){

		painelExcluirUsuario = new JPanel();
		painelExcluirUsuario.setBorder(BorderFactory.createTitledBorder("Excluir usuário"));
		painelExcluirUsuario.setLayout(new GridBagLayout());

		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		
		JLabel lblCdigo = new JLabel("Código: ");
		painelExcluirUsuario.add(lblCdigo, grid);

		grid.gridx = 1;
		grid.gridy = 0;
		
		codigoExcluirText = new JTextField();
		painelExcluirUsuario.add(codigoExcluirText, grid);
		codigoExcluirText.setColumns(10);

		grid.gridx = 2;
		grid.gridy = 0;
		JButton btnVerificar = new JButton("Verificar");
		painelExcluirUsuario.add(btnVerificar, grid);
		btnVerificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (!codigoExcluirText.getText().isEmpty()){
					int codigo = Integer.parseInt(codigoExcluirText.getText());
					InterfaceUsuario.verificaUsuario(codigo);
				} else {
					JOptionPane.showMessageDialog(null, "Digite algum código");
				}
			}
		});

		grid.gridx = 1;
		grid.gridy = 1;
		JButton btnExcluir = new JButton("Excluir");
		painelExcluirUsuario.add(btnExcluir, grid);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int codigo = Integer.parseInt(codigoExcluirText.getText());
				
				InterfaceUsuario.excluirUsuario(codigo);
				
			}
		});
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelExcluirUsuario);

	}

	public void painelAtualizarUsuario(){

		painelAtualizarUsuario = new JPanel();
		painelAtualizarUsuario.setBorder(BorderFactory.createTitledBorder("Atualizar usuário"));
		painelAtualizarUsuario.setLayout(new GridBagLayout());

		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JLabel lblCdigo_1 = new JLabel("Código:");
		painelAtualizarUsuario.add(lblCdigo_1, grid);

		grid.gridx = 1;
		grid.gridy = 0;
		textField_5 = new JTextField();
		painelAtualizarUsuario.add(textField_5, grid);
		textField_5.setColumns(10);

		grid.gridx = 2;
		grid.gridy = 0;
		JButton btnVerificar = new JButton("Verificar");
		painelAtualizarUsuario.add(btnVerificar, grid);
		btnVerificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (!codigoExcluirText.getText().isEmpty()){
					int codigo = Integer.parseInt(codigoExcluirText.getText());
					InterfaceUsuario.verificaUsuario(codigo);
				} else {
					JOptionPane.showMessageDialog(null, "Digite algum código");
				}
			}
		});	

		grid.gridx = 0;
		grid.gridy = 1;
		JLabel lblNome_2 = new JLabel("Nome: ");
		painelAtualizarUsuario.add(lblNome_2, grid);

		grid.gridx = 1;
		grid.gridy = 1;
		textField_6 = new JTextField();
		painelAtualizarUsuario.add(textField_6, grid);
		textField_6.setColumns(10);
		
		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblDepartamento_1 = new JLabel("Departamento:");
		painelAtualizarUsuario.add(lblDepartamento_1, grid);
		
		grid.gridx = 1;
		grid.gridy = 2;
		textField_7 = new JTextField();
		painelAtualizarUsuario.add(textField_7, grid);
		textField_7.setColumns(10);
		
		grid.gridx = 0;
		grid.gridy = 3;
		JLabel lblSenha_1 = new JLabel("Senha");
		painelAtualizarUsuario.add(lblSenha_1, grid);

		grid.gridx = 1;
		grid.gridy = 3;
		textField_8 = new JTextField();
		painelAtualizarUsuario.add(textField_8, grid);
		textField_8.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 4;
		JButton btnConfirmar = new JButton("Confirmar");
		painelAtualizarUsuario.add(btnConfirmar, grid);
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});

		this.add(BorderLayout.BEFORE_FIRST_LINE, painelAtualizarUsuario);

	}
	
	public void painelManterRequisicao(){
		
		painelManterRequisicao = new JPanel();
		painelManterRequisicao.setBorder(BorderFactory.createTitledBorder("Manter Requisição"));
		painelManterRequisicao.setLayout(new GridBagLayout());

		GridBagConstraints grid =  new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JButton btnEnviarRequisio = new JButton("Enviar requisição");
		btnEnviarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelConsultarRequisicao != null){
					painelConsultarRequisicao.setVisible(false);
				}
				
				painelManterRequisicao.setVisible(false);
				painelEnviarRequisicao();
					
			}
		});
		painelManterRequisicao.add(btnEnviarRequisio, grid);

		grid.gridx = 1;
		grid.gridy = 0;
		JButton btnConsultarRequisio = new JButton("Consultar requisição");
		btnConsultarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelEnviarRequisicao != null){
					painelEnviarRequisicao.setVisible(false);
				}
				
				painelManterRequisicao.setVisible(false);
				painelConsultarRequisicao();
			}
		});
		painelManterRequisicao.add(btnConsultarRequisio, grid);
		
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelManterRequisicao);
		
	}

	public void painelEnviarRequisicao(){
		
		painelEnviarRequisicao = new JPanel();
		painelEnviarRequisicao.setBorder(BorderFactory.createTitledBorder("Enviar Requisição"));
		painelEnviarRequisicao.setLayout(new GridBagLayout());
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JLabel lblDescrio = new JLabel("Descrição:");
		painelEnviarRequisicao.add(lblDescrio, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		textField_9 = new JTextField();
		painelEnviarRequisicao.add(textField_9, grid);
		textField_9.setColumns(10);
		
		grid.gridx = 0;
		grid.gridy = 1;
		JLabel lblTipo = new JLabel("Tipo:");
		painelEnviarRequisicao.add(lblTipo, grid);
		
		grid.gridx = 1;
		grid.gridy = 1;
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção ", "Suporte", "Aumento de banda da Internet"}));
		painelEnviarRequisicao.add(comboBox, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblPrazoMximoem = new JLabel("Prazo máximo (em dias)");
		painelEnviarRequisicao.add(lblPrazoMximoem, grid);
		
		grid.gridx = 1;
		grid.gridy = 2;
		textField_10 = new JTextField();
		painelEnviarRequisicao.add(textField_10, grid);
		textField_10.setColumns(10);
		
		grid.gridx = 1;
		grid.gridy = 3;
		JButton btnEnviar = new JButton("Enviar");
		painelEnviarRequisicao.add(btnEnviar, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelEnviarRequisicao);
	}

	public void painelConsultarRequisicao(){
		
		painelConsultarRequisicao = new JPanel();
		painelConsultarRequisicao.setBorder(BorderFactory.createTitledBorder("Enviar Requisição"));
		painelConsultarRequisicao.setLayout(new GridBagLayout());
		
		GridBagConstraints grid  = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JLabel lblTipoDaConsulta = new JLabel("Tipo da consulta: ");
		painelConsultarRequisicao.add(lblTipoDaConsulta, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Data", "Tipo de requisição"}));
		painelConsultarRequisicao.add(comboBox, grid);
		
		grid.gridx = 0;
		grid.gridy = 1;
		JLabel lblDataseEscolheu = new JLabel("Data (se escolheu por data):");
		painelConsultarRequisicao.add(lblDataseEscolheu, grid);
		
		grid.gridx = 1;
		grid.gridy = 1;
		textField_11 = new JTextField();
		painelConsultarRequisicao.add(textField_11, grid);
		textField_11.setColumns(10);
		
		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblTiposeEscolheu = new JLabel("Tipo (se escolheu por tipo):");
		painelConsultarRequisicao.add(lblTiposeEscolheu, grid);
		
		grid.gridx = 1;
		grid.gridy = 2;
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		painelConsultarRequisicao.add(comboBox_1, grid);
		
		grid.gridx = 1;
		grid.gridy = 3;
		JButton btnConsultar = new JButton("Consultar");
		painelConsultarRequisicao.add(btnConsultar, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarRequisicao);
		
	}

}
