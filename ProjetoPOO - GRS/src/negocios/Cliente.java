package negocios;

import javax.persistence.Entity;

import persistencia.Banco;

@Entity
public class Cliente extends Usuario {

	public Cliente() {

	}
		
	@Override
	public void salvarDados() {
		// aqui vai socket?
		
	}
}
