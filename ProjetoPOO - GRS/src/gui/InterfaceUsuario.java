package gui;

import java.sql.Date;

import javax.swing.JOptionPane;

import negocios.Fachada;

public class InterfaceUsuario {
	
	Fachada fachada = new Fachada();
	
	public static void menuOpcoes() { 
		
		
		// -- a implementação dos campos usuário e senha fica em autenticacao()
		// lembrar de colocar um opção para cadastrar o administrador -
		// ver como fazer isso
		
		JOptionPane.showMessageDialog(null, "Olá, <<aqui fica o nome do usuário>>! As opções disponíveis a você encontram-se abaixo: \n");
		// nesse caso, deve-se utilizar de algum mecanismo que mostre as opções de acordo com o tipo de usuário
		// OU ter algum outro mecanismo que impeça o usuario (cliente) de utilizar os métodos (polimorfismo?!)
		
		// por enquanto vou generalizar e colocar todas
		
		int menuOpcoes = Integer.parseInt(JOptionPane.showInputDialog("1 - Manter requisição\n"
				+ "2 - Manter usuário\n"
				+ "3 - Vazar ").toString());
		
		switch (menuOpcoes) {
		case 1:
			manterRequisicao();
			break;
		case 2:
			manterUsuario();
			break;
		case 3:
			int opcLogOut = JOptionPane.showConfirmDialog(null, "Você está prestes a deslogar do sistema... Caso queira continuar, selecione a opção \"Yes\".\n");
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
	
	public static void manterRequisicao()
	{
		int opcaoManterRequisicao = Integer.parseInt(JOptionPane.showInputDialog(null, "\t\tManter Requisição\t\t\n\n"
				+ "1 - Enviar requisição\n"
				+ "2 - Consultar requisição\n"
				+ "3 - Voltar...").toString());	
		
		switch (opcaoManterRequisicao) {
		case 1:
			enviarRequisicao();
			break;
		case 2:
			consultarRequisicao();
			break;
		case 3:
			manterRequisicao();
			break;
		default:
			break;
		}
	}
		
	public static void enviarRequisicao()
	{
		String descricao;
		int tipoReq;
		int prazo;
		int codigoUsuario;
		
		JOptionPane.showMessageDialog(null, "Preencha os seguintes campos:\n");
		
		descricao = JOptionPane.showInputDialog("Descricação da requisição: \n").toString();
		tipoReq = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de requisição: \n" + Fachada.getInstance().getTipoRequisicaoString()).toString());
		prazo = Integer.parseInt(JOptionPane.showInputDialog("Dê um prazo máximo para o atendimento da requisição: ").toString());
		
		codigoUsuario = autenticacao(); // mecanismo para poder setar usuario
		
		if (codigoUsuario != -1)
			Fachada.getInstance().enviarRequisicao(descricao, tipoReq, prazo, codigoUsuario);
		else 
			JOptionPane.showMessageDialog(null, "Não foi possível enviar a requisição.");
	}
		
	public static void consultarRequisicao()
	{
		int opcaoConsulta;
		opcaoConsulta = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções abaixo: \n"
				+ "1 - Data\n"
				+ "2 - Tipo de requisição").toString());
		
		switch (opcaoConsulta) {
		case 1: {
			String data;
			data = JOptionPane.showInputDialog("Digite a data (yyyy-mm-dd): \n");
			Fachada.getInstance().consultarRequisicoes(Date.valueOf(data));
			// falta o resto - chamar metodo mostraVenda, se for útil 
			break;
			
		}
		case 2: {
			int tipoReq;
			tipoReq = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de requisição: \n" + Fachada.getInstance().getTipoRequisicaoString()).toString());
			
			Fachada.getInstance().consultarRequisicoes(tipoReq);
			// falta o resto
		}
		default:
			break;
		}
		
	}
		
	public static void manterUsuario()
	{
			
	}
		
	public static void criarUsuario()
	{
			
	}
		
	public static void consultarUsuario()
	{
			
	}
		
	public static void excluirUsuario()
	{
			
	}
		
	public static void atualizarUsuario()
	{
			
	}
		
	public static int autenticacao()
	{
		String usuario;
		String senha;
		int opcaoAut = 1;
		int autenticou; // -1 = negativo
		
		// mensagem que falta analisar melhor
		JOptionPane.showMessageDialog(null, "Olá, você está utilizando o Gerenciador de Requisições de serviços.\n"
				+ "Por favor, digite seu usuário e senha:");
		
		
		do {
			usuario = JOptionPane.showInputDialog("Digite o usuário: ").toString();
			senha = JOptionPane.showInputDialog("Digite a senha: ").toString();
			
			autenticou = Fachada.getInstance().autenticacao(usuario, senha);
			
			if (autenticou == -1) {
				opcaoAut = JOptionPane.showConfirmDialog(null, "Usuário e/ou senha digitados incorreto(s).\nDeseja tentar novamente?");
			} else {
				JOptionPane.showMessageDialog(null, "Autenticação feita com sucesso!");
			}
		} while (opcaoAut == JOptionPane.YES_OPTION);
			
		return autenticou;
	}
	
	public static void main(String[] args) {
		// falta rever a inicialização aqui
		autenticacao();
		menuOpcoes();
	}
}

