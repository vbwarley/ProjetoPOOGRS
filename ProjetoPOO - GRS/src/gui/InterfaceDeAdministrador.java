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

	//Paineis
	private JPanel painelPrincipal;
	private JPanel painelCriarUsuario;
	private JPanel painelManterUsuarios;
	private JPanel painelConsultarUsuarios;
	private JPanel painelExcluirUsuario;
	private JPanel painelAtualizarUsuario;
	private JPanel painelManterRequisicao;
	private JPanel painelEnviarRequisicao;
	private JPanel painelConsultarRequisicao;
	
	//Campos de texto
	private JTextField nomeText;
	private JTextField senhaText;
	private JTextField departamentoText;
	private JTextField nomeConsultarText;
	private JTextField codigoExcluirText;
	private JTextField codigoAtualizarUsuarioText;
	private JTextField nomeAtualizarText;
	private JTextField departamentoAtualizarText;
	private JTextField descricaoEnviarText;
	private JTextField prazoText;
	private JTextField dataText;
	
	//ComboBoxes
	private JComboBox tipoRequisicaoCB;
	private JComboBox tipoDeConsultaRequsicaoCB;
	private JComboBox tipoRequisicaoConsultarCB;

	//codigoUsuario, usado para identificar o usuário que se logou na primeira interface
	private static int codigoUsuario;

	/**
	 * Launch the application.
	 */
	public static void executar(int codigo) {
		codigoUsuario = codigo;

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
		
		grid.gridx = 2;
		grid.gridy = 0;
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] args = new String[0];
				
				interfaceLoginCadastro.main(args);
				JOptionPane.showMessageDialog(null, "Saindo da interface de Administrador");
				dispose();
			}
		});
		
		
		painelPrincipal.add(sair, grid);

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

		grid.gridx = 1;
		grid.gridy = 2;
		
		JButton botaoVoltarManterUsr = new JButton("Voltar");
		botaoVoltarManterUsr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				painelManterUsuarios.setVisible(false);
				
				painelPrincipal.setVisible(true);
			}
		});
		
		painelManterUsuarios.add(botaoVoltarManterUsr, grid);
		
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

		grid.gridx = 1;
		grid.gridy = 6;
		JButton botaoVoltarCriarUsr = new JButton("Voltar");
		botaoVoltarCriarUsr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				painelCriarUsuario.setVisible(false);
				painelManterUsuarios();
			}
		});
		
		painelCriarUsuario.add(botaoVoltarCriarUsr, grid);
		
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
		
		grid.gridx = 1;
		grid.gridy = 2;
		JButton botaoVoltarConsultarUsr = new JButton("Voltar");
		botaoVoltarConsultarUsr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				painelConsultarUsuarios.setVisible(false);
				painelManterUsuarios();
			}
		});
		
		painelConsultarUsuarios.add(botaoVoltarConsultarUsr, grid);

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
		
		grid.gridx = 2;
		grid.gridy = 1;
		JButton botaoVoltarExcluirUsr = new JButton("Voltar");
		botaoVoltarExcluirUsr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				painelExcluirUsuario.setVisible(false);
				painelManterUsuarios();
			}
		});
		
		painelExcluirUsuario.add(botaoVoltarExcluirUsr, grid);

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
		codigoAtualizarUsuarioText = new JTextField();
		painelAtualizarUsuario.add(codigoAtualizarUsuarioText, grid);
		codigoAtualizarUsuarioText.setColumns(10);

		grid.gridx = 2;
		grid.gridy = 0;
		JButton btnVerificar = new JButton("Verificar");
		painelAtualizarUsuario.add(btnVerificar, grid);
		btnVerificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (!codigoAtualizarUsuarioText.getText().isEmpty()){
					int codigo = Integer.parseInt(codigoAtualizarUsuarioText.getText());
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
		nomeAtualizarText = new JTextField();
		painelAtualizarUsuario.add(nomeAtualizarText, grid);
		nomeAtualizarText.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblDepartamento_1 = new JLabel("Departamento:");
		painelAtualizarUsuario.add(lblDepartamento_1, grid);

		grid.gridx = 1;
		grid.gridy = 2;
		departamentoAtualizarText = new JTextField();
		painelAtualizarUsuario.add(departamentoAtualizarText, grid);
		departamentoAtualizarText.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 3;
		JButton btnConfirmar = new JButton("Confirmar");
		painelAtualizarUsuario.add(btnConfirmar, grid);
		btnConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int codigo = Integer.parseInt(codigoAtualizarUsuarioText.getText());
				InterfaceUsuario.atualizarUsuario(codigo, nomeAtualizarText.getText(), departamentoAtualizarText.getText());

			}
		});
		
		grid.gridx = 1;
		grid.gridy = 4;
		JButton botaoVoltarExcluirUsr = new JButton("Voltar");
		botaoVoltarExcluirUsr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				painelAtualizarUsuario.setVisible(false);
				painelManterUsuarios();
			}
		});
		
		painelAtualizarUsuario.add(botaoVoltarExcluirUsr, grid);

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

		grid.gridx = 2;
		grid.gridy = 0;
		JButton botaoVoltarManterReq = new JButton("Voltar");
		botaoVoltarManterReq.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				painelManterRequisicao.setVisible(false);
				
				painelPrincipal.setVisible(true);
			}
		});
		
		painelManterRequisicao.add(botaoVoltarManterReq, grid);
		
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
		descricaoEnviarText = new JTextField();
		painelEnviarRequisicao.add(descricaoEnviarText, grid);
		descricaoEnviarText.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 1;
		JLabel lblTipo = new JLabel("Tipo:");
		painelEnviarRequisicao.add(lblTipo, grid);

		grid.gridx = 1;
		grid.gridy = 1;
		tipoRequisicaoCB = new JComboBox();
		tipoRequisicaoCB.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		painelEnviarRequisicao.add(tipoRequisicaoCB, grid);

		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblPrazoMximoem = new JLabel("Prazo máximo (em dias)");
		painelEnviarRequisicao.add(lblPrazoMximoem, grid);

		grid.gridx = 1;
		grid.gridy = 2;
		prazoText = new JTextField();
		painelEnviarRequisicao.add(prazoText, grid);
		prazoText.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 3;
		JButton btnEnviar = new JButton("Enviar");
		painelEnviarRequisicao.add(btnEnviar, grid);


		btnEnviar.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				int codigoTipoRequisicao = 1;

				if (tipoRequisicaoCB.getSelectedItem().equals("Ajuda")){
					codigoTipoRequisicao = 1;
				} else if (tipoRequisicaoCB.getSelectedItem().equals("Manutenção")){
					codigoTipoRequisicao = 2;
				} else if (tipoRequisicaoCB.getSelectedItem().equals("Suporte")){
					codigoTipoRequisicao = 3;
				} else if (tipoRequisicaoCB.getSelectedItem().equals("Aumento de banda da Internet")){
					codigoTipoRequisicao = 4;
				}

				if (prazoText.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Digite algum valor (número inteiro) para dias");
				} else {
					int prazo = Integer.parseInt(prazoText.getText());
					InterfaceUsuario.enviarRequisicao(descricaoEnviarText.getText(), codigoTipoRequisicao, prazo, codigoUsuario);
				}
				}
		});
		
		grid.gridx = 1;
		grid.gridy = 4;
		JButton botaoVoltarEnviarReq = new JButton("Voltar");
		botaoVoltarEnviarReq.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				painelEnviarRequisicao.setVisible(false);
				
				painelManterRequisicao();
			}
		});
		
		painelEnviarRequisicao.add(botaoVoltarEnviarReq, grid);

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
		tipoDeConsultaRequsicaoCB = new JComboBox();
		tipoDeConsultaRequsicaoCB.setModel(new DefaultComboBoxModel(new String[] {"Data", "Tipo de requisição"}));
		painelConsultarRequisicao.add(tipoDeConsultaRequsicaoCB, grid);

		grid.gridx = 0;
		grid.gridy = 1;
		JLabel lblDataseEscolheu = new JLabel("Data (se escolheu por data):");
		painelConsultarRequisicao.add(lblDataseEscolheu, grid);

		grid.gridx = 1;
		grid.gridy = 1;
		dataText = new JTextField();
		painelConsultarRequisicao.add(dataText, grid);
		dataText.setColumns(10);

		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblTiposeEscolheu = new JLabel("Tipo (se escolheu por tipo):");
		painelConsultarRequisicao.add(lblTiposeEscolheu, grid);

		grid.gridx = 1;
		grid.gridy = 2;
		tipoRequisicaoConsultarCB = new JComboBox();
		tipoRequisicaoConsultarCB.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		painelConsultarRequisicao.add(tipoRequisicaoConsultarCB, grid);

		grid.gridx = 1;
		grid.gridy = 3;
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (tipoDeConsultaRequsicaoCB.getSelectedItem().equals("Data")){
					
					if (dataText.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Digite um valor válido para data! (aaaa-mm-dd) ");
					} else {
						InterfaceUsuario.consultarRequisicao(dataText.getText());
					}
				} else if (tipoDeConsultaRequsicaoCB.getSelectedItem().equals("Tipo de requisição")){
					int codigoTipoRequisicao = 1;

					if (tipoRequisicaoConsultarCB.getSelectedItem().equals("Ajuda")){
						codigoTipoRequisicao = 1;
					} else if (tipoRequisicaoConsultarCB.getSelectedItem().equals("Manutenção")){
						codigoTipoRequisicao = 2;
					} else if (tipoRequisicaoConsultarCB.getSelectedItem().equals("Suporte")){
						codigoTipoRequisicao = 3;
					} else if (tipoRequisicaoConsultarCB.getSelectedItem().equals("Aumento de banda da Internet")){
						codigoTipoRequisicao = 4;
					}					
					
					InterfaceUsuario.consultarRequisicao(codigoTipoRequisicao);
					
				}
				
			}
		});
		
		painelConsultarRequisicao.add(btnConsultar, grid);
		
		grid.gridx = 1;
		grid.gridy = 4;
		JButton botaoVoltarConsultarReq = new JButton("Voltar");
		botaoVoltarConsultarReq.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				painelConsultarRequisicao.setVisible(false);
				
				painelManterRequisicao();
			}
		});
		
		painelConsultarRequisicao.add(botaoVoltarConsultarReq, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarRequisicao);

	}

}
