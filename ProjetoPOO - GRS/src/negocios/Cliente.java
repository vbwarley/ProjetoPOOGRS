package negocios;

import javax.persistence.Entity;

import persistencia.Banco;

@Entity
public class Cliente extends Usuario {

	public Cliente() {

	}
	
	public Cliente(String nome, String departamento, String senha) {
		setNome(nome);
		setDepartamento(departamento);
		setSenha(senha);
	}
	
	@Override
	public void salvarDados() {
		Banco.getInstance().salvarUsuario(this);;
	}
}
