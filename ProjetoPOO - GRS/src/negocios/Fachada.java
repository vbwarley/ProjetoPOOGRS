package negocios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import persistencia.Banco;

public class Fachada {

	// criando singleton
	private static Fachada instance = new Fachada();
	private UsuarioFactory factory = new UsuarioFactory();

	public Fachada() {

	}

	public static Fachada getInstance() {
		return instance;
	}

	public void enviarRequisicao(String descricaoRequisicao, int tipoRequisicao, int prazoParaTermino_dias, int codigoUsuario) {
		Usuario usuario = Usuario.consultarUsuario(codigoUsuario);

		Requisicao requisicao = new Requisicao(descricaoRequisicao, Usuario.getTipoRequisicao(tipoRequisicao), 
				prazoParaTermino_dias, usuario);

		usuario.enviarRequisicao(requisicao);
	}

	public String consultarRequisicoes(Date data) {
		return Usuario.consultarRequisicao(data);
	}

	// essa implementação precisa ficar aqui mesmo
	public String consultarRequisicoes(int tipoRequisicao) {
		return Usuario.consultarRequisicoes(tipoRequisicao);

	}
	
	public String consultarRequisicoes(String status) {
		return Usuario.verRequisicoes(Integer.parseInt(status));
	}
	

	public void criarUsuario(String nome, String departamento, String senha) {
		Usuario usuario = factory.criar(departamento);

		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setDepartamento(departamento);

		if (!Usuario.consultarUsuario(1).getDepartamento().equalsIgnoreCase("CTI")) {
			new Administrador().salvarDados(usuario);
		} else {
			usuario.salvarDados();
		}
	}

	public String consultarUsuario(int codigo) {
		Usuario u = Usuario.consultarUsuario(codigo);
		String usuario = (u == null) ? null : u.toString();
		return usuario;
	}

	public String consultarUsuario(String nomeUsuario) {

		return Usuario.consultarUsuario(nomeUsuario);
	}

	public void excluirUsuario(int codigoUsuario) {
		Administrador.excluirUsuario(codigoUsuario);
	}

	public String atualizarUsuario(int codigo, String nome, String departamento) {
		Usuario usuario = factory.criar(departamento);

		usuario.setCodigo(codigo);
		usuario.setNome(nome);
		usuario.setDepartamento(departamento);

		usuario.salvarDados();

		return usuario.toString();
	}

	// tipo de retorno alterado
	public int autenticacao(String nomeUsuario, String senha) {
		int codigo = Usuario.autenticar(nomeUsuario, senha);

		return codigo;
	}
	
}