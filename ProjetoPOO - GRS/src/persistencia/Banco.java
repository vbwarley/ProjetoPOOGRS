package persistencia;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocios.Requisicao;
import negocios.TipoRequisicao;
import negocios.Usuario;

// Esta classe é Banco
public class Banco {
	
	private static Banco instance = new Banco();
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("grs");
	private EntityManager manager = factory.createEntityManager();
	
	public Banco() {

	}
	
	public static Banco getInstance() {
		return instance;
	}
	
	// analisar este método depois
	public Usuario autenticacao(String nomeUsuario, String senha) {
		
		Query query = manager.createNamedQuery("Usuario.findByLogin");
		query.setParameter("nome", nomeUsuario);
		query.setParameter("senha", senha);
		// teste
		
		Usuario u;
		
		try {
			u = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			u = null;
		}
		
		return u;
	}
	
	public void salvarUsuario(Usuario usuario) {		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}
	
	public void salvarRequisicao(Requisicao requisicao) {
		manager.getTransaction().begin();
		manager.persist(requisicao);
		manager.getTransaction().commit();
	}
	
	// novo método adicionado
	public Usuario consultarUsuario(int codigo) {
		return manager.find(Usuario.class, codigo);
	}
	
	public void atualizarUsuario(Usuario usuario){
		
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		
	}
	
	public void excluirUsuario(int codigo) {
		manager.getTransaction().begin();
		manager.remove(getInstance().consultarUsuario(codigo));
		manager.getTransaction().commit();
		
	}
	
	public List<Usuario> consultarUsuarios(String nome) {
		
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE nome = '" + nome + "'");
		List<Usuario> usuarios = query.getResultList();
		
		return usuarios;
	}
	
	// mudança no parametro
	// analisar
	public List<Requisicao> consultarRequisicoes(Date data) {
		
		Query query = manager.createQuery("SELECT r FROM Requisicao r WHERE data = '" + data + "'");
		List<Requisicao> requisicoes = query.getResultList();
		
		return requisicoes;
	}
	
	public List<Requisicao> consultarRequisicoes(TipoRequisicao tipoRequisicao) {
		Query query = manager.createQuery("SELECT r FROM Requisicao r WHERE tipoRequisicao = '" + tipoRequisicao + "'");
		List<Requisicao> requisicoes = query.getResultList();
		
		return requisicoes;
	}
	
}
