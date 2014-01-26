package gui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import negocios.Fachada;

public class InterfaceUsuario {
	
	private static boolean sistemaLogado;
	
	//1 para Administrador e 2 para cliente
	private static int tipoUsuario;
	
		public static void menuOpcoes() { 
			
		int menuOpcoes = Integer.parseInt(JOptionPane.showInputDialog("1 - Manter requisição\n"
				+ "2 - Manter usuário\n"
				+ "3 - Vazar ").toString());
		
		switch (menuOpcoes) {
		case 1:
			break;
		case 2:
			manterUsuario();
			break;
		case 3:
			int opcLogOut = JOptionPane.showConfirmDialog(null, "Voc� est� prestes a deslogar do sistema... Caso queira continuar, selecione a op��o \"Yes\".\n");
			if (opcLogOut == JOptionPane.YES_OPTION)
				System.exit(1);
			else
				menuOpcoes();
		default:
			JOptionPane.showMessageDialog(null, "Algo esta errado. Por favor, tente novamente.");
			menuOpcoes();
			break;
		}
	}
	
	public static void menuCliente(){
		
		int menuCliente = Integer.parseInt(JOptionPane.showInputDialog("1 - Enviar requisicaoo\n"
				+ "2 - Consultar requisicao\n"
				+ "3 - Criar conta\n"
				+ "4 - Consultar Usuario\n"
				+ "5 - Sair... ").toString());
		
		switch (menuCliente) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			int opcLogOut = JOptionPane.showConfirmDialog(null, "Voce esta prestes a deslogar do sistema... Caso queira continuar, selecione a opcao \"Yes\".\n");
			if (opcLogOut == JOptionPane.YES_OPTION)
				System.exit(1);
			else
				menuCliente();
		default:
			JOptionPane.showMessageDialog(null, "Algo esta errado. Por favor, tente novamente.");
			menuCliente();
			break;
		}
	}
	
		
	public static void enviarRequisicao(String descricao, int tipoReq, int prazo, int codigo)
	{
			Fachada.getInstance().enviarRequisicao(descricao, tipoReq, prazo, codigo);
			JOptionPane.showMessageDialog(null, "Requisição de serviço enviada com sucesso!");
		
	}
		
	public static void consultarRequisicao(String data)
	{
		String requisicoes = Fachada.getInstance().consultarRequisicoes(Date.valueOf(data));
		JOptionPane.showMessageDialog(null, "Requisições para essa data: \n"+requisicoes);
	}
	
	public static void consultarRequisicao(int tipoReq)
	{
		String requisicoes = Fachada.getInstance().consultarRequisicoes(tipoReq);
		JOptionPane.showMessageDialog(null, "Requisições para esse tipo: \n"+requisicoes);
	}
		
	public static void manterUsuario()
	{
		
		int opcaoManterUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "\t\tManter Usuario\t\t\n\n"
				+ "1 - Criar usuario\n"
				+ "2 - Consultar usuarios\n"
				+ "3 - Excluir usuario\n"
				+ "4 - Atualizar usuario\n").toString());	
		
		switch (opcaoManterUsuario) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			excluirUsuario();
			break;
		case 4:
			break;
		default:
			break;
		}	
	}
		
	public static void criarUsuario(String nome, String departamento, String senha)
	{
		Fachada.getInstance().criarUsuario(nome, departamento, senha);
	}
		
	public static void consultarUsuario(String nome)
	{
		String usuarios = Fachada.getInstance().consultarUsuario(nome);
		
		JOptionPane.showMessageDialog(null, "Usuarios encontrados com esse nome: \n" + (usuarios.equals("") ? 0 : usuarios));
	}
		
	public static void excluirUsuario()
	{
		String codigoS = JOptionPane.showInputDialog("Digite o codigo do usuario a ser excluído: ");
		
		int codigo = Integer.parseInt(codigoS);
		
		Fachada.getInstance().excluirUsuario(codigo);
		
	}
		
	//Adicionar um confirmDialog, pra perguntar se o administrador realmente quer editar o funcionario encontrado
	public static void atualizarUsuario(int codigo, String nome, String departamento)
	{		
		Fachada.getInstance().atualizarUsuario(codigo, nome, departamento);
		
	}
		
	public static int autenticacao(String usuario, String senha)
	{
		int autenticou = 0; 		
		
			autenticou = Fachada.getInstance().autenticacao(usuario, senha);
			
			if (autenticou == 0) {
				JOptionPane.showMessageDialog(null, "Usuario e/ou senha digitados incorreto(s).\n\nDeseja tentar novamente?");
			} else if (autenticou == 1) {
				JOptionPane.showMessageDialog(null, "Autenticao de adminstrador feita com sucesso!");
			} else if (autenticou  >= 2){
				JOptionPane.showMessageDialog(null, "Autenticao de cliente feita com sucesso!");
			}
			
		return autenticou;
	}
	
}

