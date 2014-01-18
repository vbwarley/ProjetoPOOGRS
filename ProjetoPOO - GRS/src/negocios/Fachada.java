package negocios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


import persistencia.Banco;

public class Fachada {
	
	// criando singleton
	private static Fachada instance = new Fachada();
	
	public Fachada() {
		
	}
	
	public static Fachada getInstance() {
		return instance;
	}
	
	// mudança do tipo do segundo parametro - denovo 
	// adição do ultimo
	public String enviarRequisicao(String descricaoRequisicao, int tipoRequisicao, int prazoParaTermino_dias, int codigoUsuario) {
		Usuario usuario = consultarUsuario(codigoUsuario);
			
		Requisicao requisicao = new Requisicao(descricaoRequisicao, getTipoRequisicao(tipoRequisicao), 
				prazoParaTermino_dias, usuario);
		
		usuario.enviarRequisicao(requisicao);
		
		// retornar string?
		return null;
	}
	
	public ArrayList<String> consultarRequisicoes(Date data) {
		
		return null;
	
	}
	
	// mudança do tipo do parâmetro e tipo de retorno
	public Collection<String> consultarRequisicoes(int tipoRequisicao) {
		TipoRequisicao tR;
		Collection<Requisicao> requisicoes;
		
		tR = getTipoRequisicao(tipoRequisicao);
		requisicoes = Banco.getInstance().consultarRequisicoes(tR);
		
		Collection<String> requisicoesString = new ArrayList<String>();
		
		for (Requisicao r : requisicoes )
			requisicoesString.add(r.toString()); 
		
		return requisicoesString;
	
	}
	
	public String criarUsuario(String nome, String departamento) {
		return null;
	}
	
	// adicionando novo método - teste
	private Usuario consultarUsuario(int codigo) {
		return Banco.getInstance().consultarUsuario(codigo);
	}
	
	public ArrayList<String> consultarUsuario(String nomeUsuario) {
		return null;
	}
	
	public String excluirUsuario(int codigoUsuario) {
		return null;
	}
	
	public String atualizarUsuario(String nome, String departamento) {
		return null;
	}
	
	// tipo de retorno alterado
	public int autenticacao(String nomeUsuario, String senha) {
		Usuario usuario = Banco.getInstance().autenticacao(nomeUsuario, senha);
		int codigo = usuario == null ? -1 : usuario.getCodigo(); 
		
		return codigo;
	}
	
	public String mostrarDetalhesUsuario(int codigo) {
		return null;
	}
	
	// adicionado
	public TipoRequisicao getTipoRequisicao(int codigo) {
		return TipoRequisicao.values()[codigo-1];
	}
	
	// adicionado
	public String getTipoRequisicaoString() {
		String tipos = "";
		
		for (int i = 0; i < TipoRequisicao.values().length; i++) 
			tipos += (i+1) + " " + TipoRequisicao.values()[i].toString() + "\n"; 
		
		return tipos;
	}
	
}
