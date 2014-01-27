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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.FlowLayout;

public class InterfaceDeAdministrador extends JFrame {

	private JPanel painelPrincipal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel painelCriarUsuario;
	private JPanel painelManterUsuarios;
	private JTextField textField_3;
	private JPanel painelConsultarUsuarios;
	private JTextField textField_4;
	private JPanel painelExcluirUsuario;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPanel painelAtualizarUsuario;
	private JTextField textField_9;
	private JTextField textField_10;
	private Container painelManterRequisicao;
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
		textField = new JTextField();
		painelCriarUsuario.add(textField, grid);
		textField.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 3;	
		JLabel lblSenha = new JLabel("Senha: ");
		painelCriarUsuario.add(lblSenha, grid);

		grid.gridx = 1;
		grid.gridy = 3;
		textField_1 = new JTextField();
		painelCriarUsuario.add(textField_1, grid);
		textField_1.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 4;
		JLabel lblDepartamento = new JLabel("Departamento:");
		painelCriarUsuario.add(lblDepartamento, grid);

		grid.gridx = 1;
		grid.gridy = 4;
		textField_2 = new JTextField();
		painelCriarUsuario.add(textField_2, grid);
		textField_2.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 5;
		JButton botaoCriarUsuario = new JButton("Criar");
		painelCriarUsuario.add(botaoCriarUsuario, grid);

		this.add(BorderLayout.BEFORE_FIRST_LINE, painelCriarUsuario);
	}

	public void painelConsultarUsuarios(){

		painelConsultarUsuarios = new JPanel();
		painelConsultarUsuarios.setLayout(new MigLayout("", "[][][grow][]", "[][]"));

		JLabel lblNome_1 = new JLabel("Nome: ");
		painelConsultarUsuarios.add(lblNome_1, "cell 0 0,alignx trailing");

		textField_3 = new JTextField();
		painelConsultarUsuarios.add(textField_3, "cell 1 0,growx");
		textField_3.setColumns(10);

		JButton botaoConsultar = new JButton("Consultar");
		painelConsultarUsuarios.add(botaoConsultar, "cell 1 1,alignx center");

		painelManterUsuarios.add(painelConsultarUsuarios, "cell 0 1,grow");
		painelManterUsuarios.setVisible(false);
		painelManterUsuarios.setVisible(true);
	}

	public void painelExcluirUsuario(){

		painelExcluirUsuario = new JPanel();
		painelExcluirUsuario.setLayout(new MigLayout("", "[][][][grow][]", "[][]"));

		JLabel lblCdigo = new JLabel("Código: ");
		painelExcluirUsuario.add(lblCdigo, "cell 0 0,alignx trailing");

		textField_4 = new JTextField();
		painelExcluirUsuario.add(textField_4, "cell 1 0,growx");
		textField_4.setColumns(10);

		JButton btnVerificar = new JButton("Verificar");
		painelExcluirUsuario.add(btnVerificar, "cell 2 0");

		JButton btnExcluir = new JButton("Excluir");
		painelExcluirUsuario.add(btnExcluir, "cell 1 1,alignx center");

		painelManterUsuarios.add(painelExcluirUsuario, "cell 0 1,grow");
		painelManterUsuarios.setVisible(false);
		painelManterUsuarios.setVisible(true);

	}

	public void painelAtualizarUsuario(){

		painelAtualizarUsuario = new JPanel();
		painelAtualizarUsuario.setLayout(new MigLayout("", "[][][grow][]", "[][][][][]"));

		JLabel lblCdigo_1 = new JLabel("Código:");
		painelAtualizarUsuario.add(lblCdigo_1, "cell 0 0,alignx trailing");

		textField_5 = new JTextField();
		painelAtualizarUsuario.add(textField_5, "cell 1 0,alignx center");
		textField_5.setColumns(10);

		JButton btnVerificar_1 = new JButton("Verificar");
		painelAtualizarUsuario.add(btnVerificar_1, "cell 2 0");

		JLabel lblNome_2 = new JLabel("Nome: ");
		painelAtualizarUsuario.add(lblNome_2, "cell 0 1,alignx trailing");

		textField_6 = new JTextField();
		painelAtualizarUsuario.add(textField_6, "cell 1 1,alignx center");
		textField_6.setColumns(10);

		JLabel lblDepartamento_1 = new JLabel("Departamento:");
		painelAtualizarUsuario.add(lblDepartamento_1, "cell 0 2,alignx trailing");

		textField_7 = new JTextField();
		painelAtualizarUsuario.add(textField_7, "cell 1 2,alignx center");
		textField_7.setColumns(10);

		JLabel lblSenha_1 = new JLabel("Senha");
		painelAtualizarUsuario.add(lblSenha_1, "cell 0 3,alignx trailing");

		textField_8 = new JTextField();
		painelAtualizarUsuario.add(textField_8, "cell 1 3,alignx center");
		textField_8.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		painelAtualizarUsuario.add(btnConfirmar, "cell 1 4");

		painelManterUsuarios.add(painelAtualizarUsuario, "cell 0 1,grow");
		painelManterUsuarios.setVisible(false);
		painelManterUsuarios.setVisible(true);

	}
	
	public void painelManterRequisicao(){
		
		painelManterRequisicao = new JPanel();
		painelPrincipal.add(painelManterRequisicao, BorderLayout.CENTER);
		painelManterRequisicao.setLayout(new MigLayout("", "[123px,grow]", "[19px][grow]"));

		JToolBar toolBar_1 = new JToolBar();
		painelManterRequisicao.add(toolBar_1, "cell 0 0,alignx left,aligny top");

		JButton btnEnviarRequisio = new JButton("Enviar requisição");
		btnEnviarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelEnviarRequisicao == null){
					painelEnviarRequisicao();
				} else {
					painelEnviarRequisicao.setVisible(true);
				}	
			}
		});
		toolBar_1.add(btnEnviarRequisio);

		JButton btnConsultarRequisio = new JButton("Consultar requisição");
		btnConsultarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelConsultarRequisicao == null){
					painelConsultarRequisicao();
				} else {
					painelConsultarRequisicao.setVisible(true);
				}
			}
		});
		toolBar_1.add(btnConsultarRequisio);
		
	}

	public void painelEnviarRequisicao(){
		
		painelEnviarRequisicao = new JPanel();
		painelEnviarRequisicao.setLayout(new MigLayout("", "[][grow][]", "[][][][]"));
		
		JLabel lblDescrio = new JLabel("Descrição:");
		painelEnviarRequisicao.add(lblDescrio, "cell 0 0,alignx center");
		
		textField_9 = new JTextField();
		painelEnviarRequisicao.add(textField_9, "cell 1 0,alignx left");
		textField_9.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		painelEnviarRequisicao.add(lblTipo, "cell 0 1,alignx center");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção ", "Suporte", "Aumento de banda da Internet"}));
		painelEnviarRequisicao.add(comboBox, "cell 1 1,alignx left");
		
		JLabel lblPrazoMximoem = new JLabel("Prazo máximo (em dias)");
		painelEnviarRequisicao.add(lblPrazoMximoem, "cell 0 2,alignx trailing");
		
		textField_10 = new JTextField();
		painelEnviarRequisicao.add(textField_10, "cell 1 2,alignx left");
		textField_10.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		painelEnviarRequisicao.add(btnEnviar, "cell 1 3");
		
		painelManterRequisicao.add(painelEnviarRequisicao, "cell 0 1,grow");
		painelManterRequisicao.setVisible(false);
		painelManterRequisicao.setVisible(true);
		
	}

	public void painelConsultarRequisicao(){
		
		painelConsultarRequisicao = new JPanel();
		painelConsultarRequisicao.setLayout(new MigLayout("", "[][grow][grow]", "[][][][]"));
		
		JLabel lblTipoDaConsulta = new JLabel("Tipo da consulta: ");
		painelConsultarRequisicao.add(lblTipoDaConsulta, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Data", "Tipo de requisição"}));
		painelConsultarRequisicao.add(comboBox, "cell 1 0,growx");
		
		JLabel lblDataseEscolheu = new JLabel("Data (se escolheu por data):");
		painelConsultarRequisicao.add(lblDataseEscolheu, "cell 0 1,alignx trailing");
		
		textField_11 = new JTextField();
		painelConsultarRequisicao.add(textField_11, "cell 1 1,alignx left");
		textField_11.setColumns(10);
		
		JLabel lblTiposeEscolheu = new JLabel("Tipo (se escolheu por tipo):");
		painelConsultarRequisicao.add(lblTiposeEscolheu, "cell 0 2,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		painelConsultarRequisicao.add(comboBox_1, "cell 1 2,growx");
		
		JButton btnConsultar = new JButton("Consultar");
		painelConsultarRequisicao.add(btnConsultar, "cell 1 3,alignx center");
		
		painelManterRequisicao.add(painelConsultarRequisicao, "cell 0 1,grow");
		painelManterRequisicao.setVisible(false);
		painelManterRequisicao.setVisible(true);
		
	}

}
