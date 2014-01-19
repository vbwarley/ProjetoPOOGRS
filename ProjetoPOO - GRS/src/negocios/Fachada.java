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
	
	// mudan�a do tipo do segundo parametro - denovo 
	// adi��o do ultimo
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
	
	// mudan�a do tipo do par�metro e tipo de retorno
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
		Usuario usuario;
		
		if (departamento.equals("CTI")){
			usuario = new Administrador();
		} else {
			usuario = new Cliente();
		}
		
		String mensagem = usuario.salvarDados();;
		return mensagem;
	}
	
	// adicionando novo m�todo - teste
	private Usuario consultarUsuario(int codigo) {
		
		return Banco.getInstance().consultarUsuario(codigo);
	}
	
	public ArrayList<String> consultarUsuario(String nomeUsuario) {
		
		ArrayList<Usuario> array = new ArrayList<Usuario>();
		
		array = (ArrayList<Usuario>) Banco.getInstance().consultarUsuarios(nomeUsuario);
		
		ArrayList<String> informacoes = new ArrayList<String>();
		
		for (int i = 0; i < Banco.getInstance().consultarUsuarios(nomeUsuario).size(); i++){
			informacoes.add(array.get(i).toString());
		}
		
		
		return informacoes;
	}
	
	public String excluirUsuario(int codigoUsuario) {
		
		return Banco.getInstance().excluirUsuario(codigoUsuario);
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
