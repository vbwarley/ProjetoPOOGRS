package negocios;

import javax.persistence.Entity;

import persistencia.Banco;

@Entity
public class Cliente extends Usuario {

	public Cliente() {

	}
	
	@Override
	public String salvarDados() {
		
		String mensagem = Banco.getInstance().salvarUsuario(this);;
		return mensagem;
	}

	@Override
	public String excluirUsuario() {
		return null;
	}
	
	

}
