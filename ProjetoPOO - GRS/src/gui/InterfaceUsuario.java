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
			
	public static void criarUsuario(String nome, String departamento, String senha)
	{
		Fachada.getInstance().criarUsuario(nome, departamento, senha);
	}
		
	public static void consultarUsuario(String nome)
	{
		String usuarios = Fachada.getInstance().consultarUsuario(nome);
		
		JOptionPane.showMessageDialog(null, "Usuarios encontrados com esse nome: \n" + (usuarios.equals("") ? 0 : usuarios));
	}
		
	public static void excluirUsuario(int codigo)
	{

		Fachada.getInstance().excluirUsuario(codigo);
		
		JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
		
	}
		
	//Adicionar um confirmDialog, pra perguntar se o administrador realmente quer editar o funcionario encontrado
	public static void atualizarUsuario(int codigo, String nome, String departamento)
	{		
		Fachada.getInstance().atualizarUsuario(codigo, nome, departamento);
		
		JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso, novos dados: \n" + Fachada.getInstance().consultarUsuario(codigo));
		
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
	
	public static void verificaUsuario(int codigo){
		
		if (Fachada.getInstance().consultarUsuario(codigo) == null){
			JOptionPane.showMessageDialog(null, "Usuário inválido!");
		} else {
			JOptionPane.showMessageDialog(null, "Usuário válido!");
		}
		
	}
	
}

