package negocios;

public class UsuarioFactory {
	
	public Usuario criar(String departamento) {
		if (departamento.equals("CTI")) {
			return new Administrador();
		} else if (!departamento.equals("CTI")) {
			return new Cliente();
		} else {
			throw new IllegalArgumentException("Departamento não suportado.");
		}
	}
}
