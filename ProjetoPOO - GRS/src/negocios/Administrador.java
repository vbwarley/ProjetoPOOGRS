package negocios;

import javax.persistence.Entity;

import persistencia.Banco;

@Entity
public class Administrador extends Usuario {

	
	public Administrador() {

	}
	
	@Override
	public void salvarDados() {
		Banco.getInstance().salvarUsuario(this);
	}

	public static void excluirUsuario(int codigo) {
		Banco.getInstance().excluirUsuario(codigo);
	}
	
}
