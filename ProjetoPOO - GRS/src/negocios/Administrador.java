package negocios;

import javax.persistence.Entity;

import persistencia.Banco;

@Entity
public class Administrador extends Usuario {

	
	
	public Administrador() {

	}
	
	@Override
	public String salvarDados() {
		String mensagem = Banco.getInstance().salvarUsuario(this);;
		return mensagem;
	}

	@Override
	public String excluirUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
