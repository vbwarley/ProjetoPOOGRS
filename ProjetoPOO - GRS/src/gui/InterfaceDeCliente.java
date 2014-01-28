package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class InterfaceDeCliente extends JFrame {

	private static int codigoUsuario = 2;
	
	//Paineis
	private JPanel painelPrincipal;
	private JPanel painelEnviarRequisicao;
	private JPanel painelConsultarRequisicao;
	private JPanel painelConsultarUsuario;
	
	//Campos de texto
	private JTextField descricaoText;
	private JTextField prazoText;
	private JTextField nomeConsultaText;
	private JTextField dataText;
	
	//ComboBoxes
	private JComboBox consultarRequisicaoCB;
	private JComboBox enviarRequisicaoCB;
	private JComboBox tipoConsultaCB;
		
	/**
	 * Launch the application.
	 */
	public static void executar(int codigo) {
		
		codigoUsuario = codigo;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeCliente frame = new InterfaceDeCliente();
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
	public InterfaceDeCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SGRS - DourLey");
		setBounds(100, 100, 600, 300);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(BorderFactory.createTitledBorder("Menu"));
		painelPrincipal.setLayout(new GridBagLayout());
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelPrincipal);
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JButton btnEnviarRequisio = new JButton("Enviar requisição");
		btnEnviarRequisio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (painelConsultarRequisicao != null){
					painelConsultarRequisicao.setVisible(false);
				} if (painelConsultarUsuario != null){
					painelConsultarUsuario.setVisible(false);
				} 
				
				painelPrincipal.setVisible(false);
				
				painelEnviarRequisicao();
			}
		});
		painelPrincipal.add(btnEnviarRequisio, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		JButton btnConsultarRequisio = new JButton("Consultar requisição");
		btnConsultarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelEnviarRequisicao != null){
					painelEnviarRequisicao.setVisible(false);
				} if (painelConsultarUsuario != null){
					painelConsultarUsuario.setVisible(false);
				}
				
				painelPrincipal.setVisible(false);
				painelConsultarRequisicao();			
			}
		});
		painelPrincipal.add(btnConsultarRequisio, grid);

		grid.gridx = 0;
		grid.gridy = 1;
		JButton btnConsultarUsurio = new JButton("Consultar usuário");
		btnConsultarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelEnviarRequisicao != null){
					painelEnviarRequisicao.setVisible(false);
				} if (painelConsultarRequisicao != null){
					painelConsultarRequisicao.setVisible(false);
				}
				
				painelPrincipal.setVisible(false);
				painelConsultarUsuario();
			}
		});
		painelPrincipal.add(btnConsultarUsurio, grid);
		
		grid.gridx = 1;
		grid.gridy = 1;
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = new String[0];
				
				interfaceLoginCadastro.main(args);
				JOptionPane.showMessageDialog(null, "Saindo da interface de cliente!");
				dispose();
			}
		});
		painelPrincipal.add(btnSair, grid);
		
		
	}
	
	public void painelEnviarRequisicao(){
		
		painelEnviarRequisicao = new JPanel();
		painelEnviarRequisicao.setBorder(BorderFactory.createTitledBorder("Enviar requisição"));
		painelEnviarRequisicao.setLayout(new GridBagLayout());
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		painelEnviarRequisicao.add(lblNewLabel, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		descricaoText = new JTextField();
		painelEnviarRequisicao.add(descricaoText, grid);
		descricaoText.setColumns(10);
		
		grid.gridx = 0;
		grid.gridy = 1;
		JLabel lblTipo = new JLabel("Tipo:");
		painelEnviarRequisicao.add(lblTipo, grid);
		
		grid.gridx = 1;
		grid.gridy = 1;
		enviarRequisicaoCB = new JComboBox();
		enviarRequisicaoCB.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da internet"}));
		enviarRequisicaoCB.addComponentListener(new ComponentAdapter() {});
		
		painelEnviarRequisicao.add(enviarRequisicaoCB, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;
		JLabel lblPrazoMximoem = new JLabel("Prazo máximo (em dias):");
		painelEnviarRequisicao.add(lblPrazoMximoem, grid);
		
		grid.gridx = 1;
		grid.gridy = 2;
		prazoText = new JTextField();
		painelEnviarRequisicao.add(prazoText, grid);
		prazoText.setColumns(10);

		grid.gridx = 1;
		grid.gridy = 3;
		JButton btnEnviarRequisicao = new JButton("Enviar");
		painelEnviarRequisicao.add(btnEnviarRequisicao, grid);
		btnEnviarRequisicao.addActionListener(new ActionListener() {
			int codigoTipo = 1;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (enviarRequisicaoCB.getSelectedItem().equals("Ajuda")){
					codigoTipo = 1;
				} else if (enviarRequisicaoCB.getSelectedItem().equals("Manutenção")){
					codigoTipo = 2;
				} else if (enviarRequisicaoCB.getSelectedItem().equals("Suporte")){
					codigoTipo = 3;
				} else if (enviarRequisicaoCB.getSelectedItem().equals("Aumento da banda de internet")){
					codigoTipo = 4;
				} 
				
				int prazo = Integer.parseInt(prazoText.getText());
				
				InterfaceUsuario.enviarRequisicao(descricaoText.getText(), codigoTipo, prazo, codigoUsuario);
				
				painelEnviarRequisicao();
			}
		});
		
		grid.gridx = 1;
		grid.gridy = 4;
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelEnviarRequisicao.setVisible(false);
				painelPrincipal.setVisible(true);
				
			}
		});
		
		painelEnviarRequisicao.add(btnSair, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelEnviarRequisicao);
		
	}
	
	public void painelConsultarRequisicao(){
		
		
		painelConsultarRequisicao = new JPanel();
		painelConsultarRequisicao.setBorder(BorderFactory.createTitledBorder("Consultar requisição"));
		painelConsultarRequisicao.setLayout(new GridBagLayout());
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de consulta");
		painelConsultarRequisicao.add(lblNewLabel_1, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		tipoConsultaCB = new JComboBox();
		tipoConsultaCB.setModel(new DefaultComboBoxModel(new String[] {"Data", "Tipo de requisição"}));
		painelConsultarRequisicao.add(tipoConsultaCB, grid);
		
		grid.gridx = 0;
		grid.gridy = 1;
		JLabel data = new JLabel("Data: (se você escolheu por data)");
		painelConsultarRequisicao.add(data, grid);
		
		grid.gridx = 1;
		grid.gridy = 1;
		dataText = new JTextField(15);
		painelConsultarRequisicao.add(dataText, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;
		JLabel opcao = new JLabel("Tipo: (se você escolheu por tipo)");
		painelConsultarRequisicao.add(opcao, grid);

		grid.gridx = 1;
		grid.gridy = 2;
		consultarRequisicaoCB = new JComboBox();
		consultarRequisicaoCB.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		consultarRequisicaoCB.setSize(15, 5);
		painelConsultarRequisicao.add(consultarRequisicaoCB, grid);
		
		grid.gridx = 1;
		grid.gridy = 3;
		JButton consultarRequisicao = new JButton("Consultar");
		painelConsultarRequisicao.add(consultarRequisicao, grid);
		consultarRequisicao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int codigoTipo = 1;
				
				if (consultarRequisicaoCB.getSelectedItem().equals("Ajuda")){
					codigoTipo = 1;
				} else if (consultarRequisicaoCB.getSelectedItem().equals("Manutenção")){
					codigoTipo = 2;
				} else if (consultarRequisicaoCB.getSelectedItem().equals("Suporte")){
					codigoTipo = 3;
				} else if (consultarRequisicaoCB.getSelectedItem().equals("Aumento da banda de internet")){
					codigoTipo = 4;
				} 	
				
				if (tipoConsultaCB.getSelectedItem().equals("Data")){ 
					InterfaceUsuario.consultarRequisicao(dataText.getText());
				} else if (tipoConsultaCB.getSelectedItem().equals("Tipo de requisição")){
					InterfaceUsuario.consultarRequisicao(codigoTipo);
				}
				
				painelConsultarRequisicao();
				
			}
		});
		
		grid.gridx = 1;
		grid.gridy = 4;
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelConsultarRequisicao.setVisible(false);
				painelPrincipal.setVisible(true);
				
			}
		});
		
		painelConsultarRequisicao.add(btnSair, grid);
		
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarRequisicao);
		
	}
	
	public void painelConsultarUsuario(){
		
		painelConsultarUsuario = new JPanel();
		painelConsultarUsuario.setBorder(BorderFactory.createTitledBorder("Consultar usuario"));
		painelConsultarUsuario.setLayout(new GridBagLayout());
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4, 4, 4, 4);
		
		grid.gridx = 0;
		grid.gridy = 0;
		JLabel lblNewLabel_2 = new JLabel("Nome: ");
		painelConsultarUsuario.add(lblNewLabel_2, grid);
		
		grid.gridx = 1;
		grid.gridy = 0;
		nomeConsultaText = new JTextField();
		nomeConsultaText.setText("");
		painelConsultarUsuario.add(nomeConsultaText, grid);
		nomeConsultaText.setColumns(10);
		
		grid.gridx = 1;
		grid.gridy = 1;
		JButton btnConsultar = new JButton("Consultar");
		painelConsultarUsuario.add(btnConsultar, grid);
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				InterfaceUsuario.consultarUsuario(nomeConsultaText.getText());
				
			}
		});
		
		grid.gridx = 1;
		grid.gridy = 2;
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelConsultarUsuario.setVisible(false);
				painelPrincipal.setVisible(true);
				
			}
		});
		
		painelConsultarUsuario.add(btnSair, grid);
		
		this.add(BorderLayout.BEFORE_FIRST_LINE, painelConsultarUsuario);
		
	}

}
