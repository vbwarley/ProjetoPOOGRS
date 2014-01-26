package negocios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	public void enviarRequisicao(String descricaoRequisicao, int tipoRequisicao, int prazoParaTermino_dias, int codigoUsuario) {
		Usuario usuario = consultarUsuario(codigoUsuario);
			
		Requisicao requisicao = new Requisicao(descricaoRequisicao, getTipoRequisicao(tipoRequisicao), 
				prazoParaTermino_dias, usuario);
		
		usuario.enviarRequisicao(requisicao);
		
	}
	
	public String consultarRequisicoes(Date data) {
		List<Requisicao> requisicoes;
		
		requisicoes = Banco.getInstance().consultarRequisicoes(data);
		
		String requisicoesString = "";
		
		for (Requisicao r : requisicoes )
			requisicoesString += r.toString() + "-*-";
		
		return requisicoesString;
	}
	
	// mudan�a do tipo do par�metro e tipo de retorno
	public String consultarRequisicoes(int tipoRequisicao) {
		List<Requisicao> requisicoes;
	
		requisicoes = Banco.getInstance().consultarRequisicoes(getTipoRequisicao(tipoRequisicao));
		
		String requisicoesString = "";
		
		for (Requisicao r : requisicoes )
			requisicoesString += r.toString() + "-*-";
		
		return requisicoesString;
	
	}
	
	public void criarUsuario(String nome, String departamento, String senha) {
		Usuario usuario;
		
		if (departamento.equals("CTI")){
			usuario = new Administrador(nome, departamento, senha);
		} else {
			usuario = new Cliente(nome, departamento, senha);
		}
		
		usuario.salvarDados();;
	}
	
	// adicionando novo m�todo - teste
	private Usuario consultarUsuario(int codigo) {
		
		return Usuario.consultarUsuario(codigo);
	}
	
	
	public String consultarUsuarioEdicao(int codigo) {
		
		return Banco.getInstance().consultarUsuario(codigo).toString();
	}
	
	public List<String> consultarUsuario(String nomeUsuario) {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios = Banco.getInstance().consultarUsuarios(nomeUsuario);
		
		List<String> informacoes = new ArrayList<String>();
		
		for (Usuario u : usuarios)
			informacoes.add(u.toString());
				
		return informacoes;
	}
	
	public void excluirUsuario(int codigoUsuario) {
		Administrador.excluirUsuario(codigoUsuario);
	}
	
	public String atualizarUsuario(int codigo, String nome, String departamento) {
		Usuario usuario;
		
		if (departamento.equals("CTI")){
			usuario = new Administrador();
		} else {
			usuario = new Cliente();
		}
		
		usuario.setCodigo(codigo);
		usuario.setNome(nome);
		usuario.setDepartamento(departamento);
		
		Banco.getInstance().atualizarUsuario(usuario);
		
		return null;
	}
	
	// tipo de retorno alterado
	public int autenticacao(String nomeUsuario, String senha) {
		int codigo = Usuario.autenticar(nomeUsuario, senha);
				
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
