package negocios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import negocios.Requisicao;
import persistencia.Banco;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name="Usuario.findByLogin", 
		query="select u from Usuario u where u.nome = :nome and u.senha = :senha")
public abstract class Usuario {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String nome;
	private String departamento;
	private String senha;
	
	// novo atributo
	@OneToMany(mappedBy="usuario")
	private Collection<Requisicao> requisicoes = new ArrayList<Requisicao>();
	
	public abstract void salvarDados();
	
	// novo m�todo
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
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public static int autenticar(String nome, String senha) {
		Usuario usuario = Banco.getInstance().autenticacao(nome, senha);
		int codigo = 0;
		
		if (usuario != null)
			codigo = usuario.getCodigo(); 
		
		return codigo;
	}
	
	public static Usuario consultarUsuario(int codigo) {
		return Banco.getInstance().consultarUsuario(codigo);
	}
	
	public static String consultarUsuario(String nome) {
		List<Usuario> usuarios = Banco.getInstance().consultarUsuario(nome);
		String usuariosString = "";
		
		for (Usuario u : usuarios)
			usuariosString += u.toString();
		
		return usuariosString;
	}
	
	public static String consultarRequisicao(Date data) {
		List<Requisicao> requisicoes = Banco.getInstance().consultarRequisicoes(data);
		String requisicoesString = "";
		
		for (Requisicao r : requisicoes)
			requisicoesString += r.toString();
		
		return requisicoesString;
	}
	
	public String toString(){
		String informacoes = "Código: " + this.codigo +"\nNome: " + this.nome + "\nDepartamento: "+ this.departamento;	
		return informacoes;
	}	
}
