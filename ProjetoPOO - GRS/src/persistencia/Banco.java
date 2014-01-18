package persistencia;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocios.Requisicao;
import negocios.TipoRequisicao;
import negocios.Usuario;

// Esta classe � Banco
public class Banco {
	
	private static Banco instance = new Banco();
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("grs");
	private EntityManager manager = factory.createEntityManager();
	
	public Banco() {

	}
	
	public static Banco getInstance() {
		return instance;
	}
	
	// analisar este m�todo depois
	public Usuario autenticacao(String nomeUsuario, String senha) {
		
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE nome = '" + nomeUsuario + "' AND "
				+ "senha = '" + senha + "'");
		
		// teste
		List<Usuario> usuarios = query.getResultList();
		Usuario u = usuarios.get(0);
		
		return u;
	}
	
	public String salvarUsuario(Usuario usuario) {
		
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		String mensagem = "Usuário cadastrado com sucesso!";
		return mensagem;
	}
	
	public String salvarRequisicao(Requisicao requisicao) {
		return null;
	}
	
	// novo m�todo adicionado
	public Usuario consultarUsuario(int codigo) {
		manager.getTransaction().begin();
		Usuario u = manager.find(Usuario.class, codigo);
		
		return u;
	}
	
	public Collection<Usuario> consultarUsuarios(String nome) {
		return null;
	}
	
	// mudan�a no parametro
	// analisar
	public Collection<Requisicao> consultarRequisicoes(Date data) {
		
		Query query = manager.createQuery("SELECT r FROM Requisicao r WHERE data = '" + data + "'");
		Collection<Requisicao> requisicoes = query.getResultList();
		
		return requisicoes;
	}
	
	public Collection<Requisicao> consultarRequisicoes(TipoRequisicao tipoRequisicao) {
		return null;
	}
	
}
