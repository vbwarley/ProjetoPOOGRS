package negocios;

import javax.persistence.Entity;


@Entity
public class Cliente extends Usuario {

	public Cliente() {

	}
		
	@Override
	public void salvarDados() {
		// aqui vai socket?
		SocketClient sc = new SocketClient();
		sc.salvarCliente(this);
		
	}
}
