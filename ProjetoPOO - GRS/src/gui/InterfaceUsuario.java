package gui;

import java.sql.Date;

import javax.swing.JOptionPane;

import negocios.Fachada;

public class InterfaceUsuario {
	
	private static boolean sistemaLogado;
	
	//1 para Administrador e 2 para cliente
	private static int tipoUsuario;
	
	public static void menuOpcoes() { 
		
		
		// -- a implementa��o dos campos usu�rio e senha fica em autenticacao()
		// lembrar de colocar um op��o para cadastrar o administrador -
		// ver como fazer isso
		
		JOptionPane.showMessageDialog(null, "Ol�, <<aqui fica o nome do usu�rio>>! As op��es dispon�veis a voc� encontram-se abaixo: \n");
		// nesse caso, deve-se utilizar de algum mecanismo que mostre as op��es de acordo com o tipo de usu�rio
		// OU ter algum outro mecanismo que impe�a o usuario (cliente) de utilizar os m�todos (polimorfismo?!)
		
		// por enquanto vou generalizar e colocar todas
		
		int menuOpcoes = Integer.parseInt(JOptionPane.showInputDialog("1 - Manter requisi��o\n"
				+ "2 - Manter usu�rio\n"
				+ "3 - Vazar ").toString());
		
		switch (menuOpcoes) {
		case 1:
			manterRequisicao();
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
	
	public static void manterRequisicao()
	{
		int opcaoManterRequisicao = Integer.parseInt(JOptionPane.showInputDialog(null, "\t\tManter Requisi��o\t\t\n\n"
				+ "1 - Enviar requisi��o\n"
				+ "2 - Consultar requisi��o\n"
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
		
		descricao = JOptionPane.showInputDialog("Descrica��o da requisi��o: \n").toString();
		tipoReq = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de requisi��o: \n" + Fachada.getInstance().getTipoRequisicaoString()).toString());
		prazo = Integer.parseInt(JOptionPane.showInputDialog("D� um prazo m�ximo para o atendimento da requisi��o: ").toString());
		
		codigoUsuario = autenticacao(); // mecanismo para poder setar usuario
		
		if (codigoUsuario != -1)
			Fachada.getInstance().enviarRequisicao(descricao, tipoReq, prazo, codigoUsuario);
		else 
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel enviar a requisi��o.");
	}
		
	public static void consultarRequisicao()
	{
		int opcaoConsulta;
		opcaoConsulta = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das op��es abaixo: \n"
				+ "1 - Data\n"
				+ "2 - Tipo de requisi��o").toString());
		
		switch (opcaoConsulta) {
		case 1: {
			String data;
			data = JOptionPane.showInputDialog("Digite a data (yyyy-mm-dd): \n");
			Fachada.getInstance().consultarRequisicoes(Date.valueOf(data));
			// falta o resto - chamar metodo mostraVenda, se for �til 
			break;
			
		}
		case 2: {
			int tipoReq;
			tipoReq = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de requisi��o: \n" + Fachada.getInstance().getTipoRequisicaoString()).toString());
			
			Fachada.getInstance().consultarRequisicoes(tipoReq);
			// falta o resto
		}
		default:
			break;
		}
		
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
			criarUsuario();
			break;
		case 2:
			consultarUsuario();
			break;
		case 3:
			excluirUsuario();
			break;
		case 4:
			atualizarUsuario();
			break;
		default:
			break;
		}	
	}
		
	public static void criarUsuario()
	{
		String nome = JOptionPane.showInputDialog("Nome: ").toString();
		String departamento = JOptionPane.showInputDialog("Departamento: ").toString();
		
		JOptionPane.showMessageDialog(null, Fachada.getInstance().criarUsuario(nome, departamento));
	}
		
	public static void consultarUsuario()
	{
		String nome = JOptionPane.showInputDialog("Digite o nome do usuario a ser consultado: ").toString();
		
		String usuarios = "";
		
		for (int i = 0; i < Fachada.getInstance().consultarUsuario(nome).size(); i++){
			
			usuarios = Fachada.getInstance().consultarUsuario(nome).get(i) + "\n";
			
		}
		
		JOptionPane.showMessageDialog(null, "Usuarios encontrados com esse nome: \n" + usuarios);
	}
		
	public static void excluirUsuario()
	{
		String codigoS = JOptionPane.showInputDialog("Digite o codigo do usuario a ser excluído: ");
		
		int codigo = Integer.parseInt(codigoS);
		
		JOptionPane.showMessageDialog(null, Fachada.getInstance().excluirUsuario(codigo));
		
	}
		
	//Adicionar um confirmDialog, pra perguntar se o administrador realmente quer editar o funcionario encontrado
	public static void atualizarUsuario()
	{
		String codigoS = JOptionPane.showInputDialog("Digite o codigo do usuario a ser editado: ");
		int codigo = Integer.parseInt(codigoS);
		
		JOptionPane.showMessageDialog(null, "Informações sobre o usuario encontrado: \n" 
		+ Fachada.getInstance().consultarUsuarioEdicao(codigo));
		
		//Aqui entra o confirmDialog, o código abaixo é para caso ele queira continuar, 
		//caso não queira, ele retorna ao menu manterUsuario
		
		String nome = JOptionPane.showInputDialog("Digite o novo nome do usuario: ");

		String departamento = JOptionPane.showInputDialog("Digite o novo departamento do usuario: ");
		
		Fachada.getInstance().atualizarUsuario(codigo, nome, departamento);
		
	}
		
	public static int autenticacao()
	{
		String usuario;
		String senha;
		int opcaoAut = 1;
		int autenticou; // -1 = negativo
		
		// mensagem que falta analisar melhor
		JOptionPane.showMessageDialog(null, "Ol�, voc� est� utilizando o Gerenciador de Requisi��es de servi�os.\n"
				+ "Por favor, digite seu usu�rio e senha:");
		
		
		do {
			usuario = JOptionPane.showInputDialog("Digite o usu�rio: ").toString();
			senha = JOptionPane.showInputDialog("Digite a senha: ").toString();
			
			autenticou = Fachada.getInstance().autenticacao(usuario, senha);
			
			if (autenticou == -1) {
				opcaoAut = JOptionPane.showConfirmDialog(null, "Usuario e/ou senha digitados incorreto(s).\nDeseja tentar novamente?");
			} else if (autenticou == 1) {
				JOptionPane.showMessageDialog(null, "Autenticao de adminstrador feita com sucesso!");
			} else if (autenticou  == 2){
				JOptionPane.showMessageDialog(null, "Autenticao de cliente feita com sucesso!");
			}
		} while (opcaoAut == JOptionPane.YES_OPTION);
			
		return autenticou;
	}
	
	public static void main(String[] args) {
		// falta rever a inicializa��o aqui
		if (!sistemaLogado){
			autenticacao();
			if (autenticacao() == 1){
				tipoUsuario = 1;
			} else if (autenticacao() == 2){
				tipoUsuario = 2;
			}
			
		} else {
			if (tipoUsuario == 1){
				menuOpcoes();
			} else if (tipoUsuario == 2){
				
			}
		}
	}
}

