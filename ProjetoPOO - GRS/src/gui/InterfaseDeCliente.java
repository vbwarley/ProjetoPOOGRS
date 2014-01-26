package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class InterfaseDeCliente extends JFrame {

	private static int codigoUsuario = 2;
	
	//Paineis
	private JPanel contentPane;
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
	private JTable usuariosEncontrados;
		
	/**
	 * Launch the application.
	 */
	public static void executar(int codigo) {
		
		codigoUsuario = codigo;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaseDeCliente frame = new InterfaseDeCliente();
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
	public InterfaseDeCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SGRS - DourLey");
		setBounds(100, 100, 515, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnEnviarRequisio = new JButton("Enviar requisição");
		btnEnviarRequisio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (painelConsultarRequisicao != null){
					painelConsultarRequisicao.setVisible(false);
				} if (painelConsultarUsuario != null){
					painelConsultarUsuario.setVisible(false);
				}
				
				painelEnviarRequisicao();
			}
		});
		toolBar.add(btnEnviarRequisio);
		
		JButton btnConsultarRequisio = new JButton("Consultar requisição");
		btnConsultarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelEnviarRequisicao != null){
					painelEnviarRequisicao.setVisible(false);
				} if (painelConsultarUsuario != null){
					painelConsultarUsuario.setVisible(false);
				}
				
				painelConsultarRequisicao();			
			}
		});
		toolBar.add(btnConsultarRequisio);
		
		JButton btnConsultarUsurio = new JButton("Consultar usuário");
		btnConsultarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelEnviarRequisicao != null){
					painelEnviarRequisicao.setVisible(false);
				} if (painelConsultarRequisicao != null){
					painelConsultarRequisicao.setVisible(false);
				}
				
				painelConsultarUsuario();
			}
		});
		toolBar.add(btnConsultarUsurio);
		
		
	}
	
	public void painelEnviarRequisicao(){
		
		painelEnviarRequisicao = new JPanel();
		
		painelEnviarRequisicao.setLayout(new MigLayout("", "[70px][grow]", "[15px][][][]"));
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		painelEnviarRequisicao.add(lblNewLabel, "cell 0 1,alignx center,aligny center");
		
		descricaoText = new JTextField();
		painelEnviarRequisicao.add(descricaoText, "cell 1 1,growx");
		descricaoText.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		painelEnviarRequisicao.add(lblTipo, "cell 0 2,alignx center");
		
		enviarRequisicaoCB = new JComboBox();
		enviarRequisicaoCB.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da internet"}));
		enviarRequisicaoCB.addComponentListener(new ComponentAdapter() {});
		
		painelEnviarRequisicao.add(enviarRequisicaoCB, "cell 1 2,growx");
		
		JLabel lblPrazoMximoem = new JLabel("Prazo máximo (em dias):");
		painelEnviarRequisicao.add(lblPrazoMximoem, "cell 0 3,alignx trailing");
		
		prazoText = new JTextField();
		painelEnviarRequisicao.add(prazoText, "cell 1 3,alignx left");
		prazoText.setColumns(10);

		JButton btnEnviarRequisicao = new JButton("Enviar");
		painelEnviarRequisicao.add(btnEnviarRequisicao, "cell 1 4,aligny center");
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
		
		contentPane.add(painelEnviarRequisicao, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
	public void painelConsultarRequisicao(){
		
		
		painelConsultarRequisicao = new JPanel();
		painelConsultarRequisicao.setLayout(new MigLayout("", "[70px][grow]", "[15px][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de consulta");
		painelConsultarRequisicao.add(lblNewLabel_1, "cell 0 0,alignx trailing,aligny top");
		
		tipoConsultaCB = new JComboBox();
		tipoConsultaCB.setModel(new DefaultComboBoxModel(new String[] {"Data", "Tipo de requisição"}));
		painelConsultarRequisicao.add(tipoConsultaCB, "cell 1 0,growx");
		
		JLabel data = new JLabel("Data: (se você escolheu por data)");
		painelConsultarRequisicao.add(data, "cell 0 1,growx");
		
		dataText = new JTextField();
		painelConsultarRequisicao.add(dataText, "cell 1 1,growx");
		
		JLabel opcao = new JLabel("Tipo: (se você escolheu por tipo)");
		painelConsultarRequisicao.add(opcao, "cell 0 2,growx");
		
		consultarRequisicaoCB = new JComboBox();
		consultarRequisicaoCB.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		painelConsultarRequisicao.add(consultarRequisicaoCB, "cell 1 2,growx");
		
		JButton consultarRequisicao = new JButton("Consultar");
		painelConsultarRequisicao.add(consultarRequisicao, "cell 1 3,growx");
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
		
		
		contentPane.add(painelConsultarRequisicao, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
	public void painelConsultarUsuario(){
		
		usuariosEncontrados = new JTable();
		
		painelConsultarUsuario = new JPanel();
		painelConsultarUsuario.setLayout(new MigLayout("", "[70px][][grow]", "[15px][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome: ");
		painelConsultarUsuario.add(lblNewLabel_2, "cell 0 0,alignx trailing,aligny top");
		
		nomeConsultaText = new JTextField();
		nomeConsultaText.setText("");
		painelConsultarUsuario.add(nomeConsultaText, "cell 1 0,growx");
		nomeConsultaText.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		painelConsultarUsuario.add(btnConsultar, "cell 1 1,alignx center");
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				InterfaceUsuario.consultarUsuario(nomeConsultaText.getText());
				
			}
		});
		
		contentPane.add(painelConsultarUsuario, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}

}
