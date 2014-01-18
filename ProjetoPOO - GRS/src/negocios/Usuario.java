package negocios;

import java.util.ArrayList;
import java.util.Collection;

import persistencia.Banco;

public abstract class Usuario {
	private int codigo;
	private String nome;
	private String departamento;
	
	// novo atributo
	private Collection<Requisicao> requisicoes = new ArrayList<Requisicao>();
	
	public abstract String salvarDados();
	public abstract String excluirUsuario();
	
	// novo método
	public void enviarRequisicao(Requisicao requisicao) {
		requisicoes.add(requisicao);
		Banco.getInstance().salvarRequisicao(requisicao);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}	
	
}
