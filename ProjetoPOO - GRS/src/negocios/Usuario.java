package negocios;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import negocios.Requisicao;
import persistencia.Banco;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	private int codigo;
	private String nome;
	private String departamento;
	
	// novo atributo
	@OneToMany(mappedBy="usuario")
	private Collection<Requisicao> requisicoes = new ArrayList<Requisicao>();
	
	public abstract String salvarDados();
	public abstract String excluirUsuario();
	
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
	
	public String toString(){
		String informacoes = "Código: " + this.codigo +"\nNome: " + this.nome + "\nDepartamento: "+ this.departamento;
				
		return informacoes;
	}
	
}
