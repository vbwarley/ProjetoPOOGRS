package persistencia;

import java.util.Calendar;
import java.util.Collection;

import negocios.Requisicao;
import negocios.TipoRequisicao;
import negocios.Usuario;

public class Banco {
	
	private Banco instance = new Banco();
	
	public Banco() {

	}
	
	public Banco getInstance() {
		return instance;
	}
	
	public String autenticacao(String nomeUsuario, String senha) {
		return null;
	}
	
	public String salvarUsuario(Usuario usuario) {
		return null;
	}
	
	public String salvarRequisicao(Requisicao requisicao) {
		return null;
	}
	
	public Collection<Usuario> consultarUsuarios(String nome) {
		return null;
	}
	
	public Collection<Requisicao> consultarRequisicoes(Calendar data) {
		return null;
	}
	
	public Collection<Requisicao> consultarRequisicoes(TipoRequisicao tipoRequisicao) {
		return null;
	}
	
}
