package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.DefaultComboBoxModel;

public class InterfaseDeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel painelEnviarRequisicao;
	private JComboBox comboBox;
	private JPanel painelConsultarRequisicao;
	private JComboBox comboBoxConsultarRequisicao;
	private JTextField textField_2;
	private JPanel painelConsultarUsuario;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
				if (painelEnviarRequisicao == null){
					painelEnviarRequisicao();
				}else {
					painelEnviarRequisicao.setVisible(true);
				}
			}
		});
		toolBar.add(btnEnviarRequisio);
		
		JButton btnConsultarRequisio = new JButton("Consultar requisição");
		btnConsultarRequisio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelConsultarRequisicao == null){
					painelConsultarRequisicao();
				}else {
					painelConsultarRequisicao.setVisible(true);
				}				
			}
		});
		toolBar.add(btnConsultarRequisio);
		
		JButton btnConsultarUsurio = new JButton("Consultar usuário");
		btnConsultarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painelConsultarUsuario == null){
					painelConsultarUsuario();
				}else {
					painelConsultarUsuario.setVisible(true);
				}
			}
		});
		toolBar.add(btnConsultarUsurio);
		
	}
	
	public void painelEnviarRequisicao(){
		
		painelEnviarRequisicao = new JPanel();
		
		painelEnviarRequisicao.setLayout(new MigLayout("", "[70px][grow]", "[15px][][][]"));
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		painelEnviarRequisicao.add(lblNewLabel, "cell 0 1,alignx center,aligny center");
		
		textField = new JTextField();
		painelEnviarRequisicao.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		painelEnviarRequisicao.add(lblTipo, "cell 0 2,alignx center");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		comboBox.addComponentListener(new ComponentAdapter() {
			
		});
		painelEnviarRequisicao.add(comboBox, "cell 1 2,growx");
		
		JLabel lblPrazoMximoem = new JLabel("Prazo máximo (em dias):");
		painelEnviarRequisicao.add(lblPrazoMximoem, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		painelEnviarRequisicao.add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);

		contentPane.add(painelEnviarRequisicao, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
	public void painelConsultarRequisicao(){
		
		
		painelConsultarRequisicao = new JPanel();
		painelConsultarRequisicao.setLayout(new MigLayout("", "[70px][grow]", "[15px][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de consulta");
		painelConsultarRequisicao.add(lblNewLabel_1, "cell 0 0,alignx trailing,aligny top");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Data", "Tipo de requisição"}));
		painelConsultarRequisicao.add(comboBox, "cell 1 0,growx");
		
		JLabel data = new JLabel("Data: (se você escolheu por data)");
		painelConsultarRequisicao.add(data, "cell 0 1,growx");
		
		JTextField dataText = new JTextField();
		painelConsultarRequisicao.add(dataText, "cell 1 1,growx");
		
		comboBoxConsultarRequisicao = new JComboBox();
		comboBoxConsultarRequisicao.setModel(new DefaultComboBoxModel(new String[] {"Ajuda", "Manutenção", "Suporte", "Aumento de banda da Internet"}));
		painelConsultarRequisicao.add(comboBoxConsultarRequisicao, "cell 1 2,growx");
		
		JLabel opcao = new JLabel("Tipo: (se você escolheu por tipo)");
		painelConsultarRequisicao.add(opcao, "cell 0 2,growx");
		
		JButton consultarRequisicao = new JButton("Consultar");
		painelConsultarRequisicao.add(consultarRequisicao, "cell 1 3,growx");
		
		contentPane.add(painelConsultarRequisicao, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}
	
	public void painelConsultarUsuario(){
		
		painelConsultarUsuario = new JPanel();
		painelConsultarUsuario.setLayout(new MigLayout("", "[70px][][grow]", "[15px][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome: ");
		painelConsultarUsuario.add(lblNewLabel_2, "cell 0 0,alignx trailing,aligny top");
		
		textField_2 = new JTextField();
		textField_2.setText("");
		painelConsultarUsuario.add(textField_2, "cell 1 0,growx");
		textField_2.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		painelConsultarUsuario.add(btnConsultar, "cell 1 1,alignx center");
		
		contentPane.add(painelConsultarUsuario, BorderLayout.CENTER);
		contentPane.setVisible(false);
		contentPane.setVisible(true);
		
	}

}
