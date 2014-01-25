package persistencia;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import excecoes.AutenticarException;
import excecoes.RequisicaoException;
import excecoes.UsuarioException;
import negocios.Requisicao;
import negocios.TipoRequisicao;
import negocios.Usuario;

public class Banco {
	
	private static Banco instance = new Banco();
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("grs");
	private EntityManager manager = factory.createEntityManager();
	
	public Banco() {

	}
	
	public static Banco getInstance() {
		return instance;
	}
	
	public Usuario autenticacao(String nomeUsuario, String senha) {
		
		Query query = manager.createNamedQuery("Usuario.findByLogin");
		query.setParameter("nome", nomeUsuario);
		query.setParameter("senha", senha);
	
		Usuario u;
		
		try {
			u = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			throw new AutenticarException("Não foi possível autenticar.");
		}
		
		return u;
	}
	
	public void criarUsuario(Usuario usuario) {		
		try {
			if (Integer.valueOf(usuario.getCodigo()) == null) {
				manager.getTransaction().begin();
				manager.persist(usuario);
				manager.getTransaction().commit();
			} else {
				manager.getTransaction().begin();
				manager.merge(usuario);
				manager.getTransaction().commit();
			}
		} catch (RuntimeException e) {
			throw new UsuarioException("Não foi possível criar o usuário.");
		}
	}
	
	public void salvarRequisicao(Requisicao requisicao) {
		try {
			manager.getTransaction().begin();
			manager.persist(requisicao);
			manager.getTransaction().commit();
		} catch (RuntimeException e) {
			throw new RequisicaoException("Não foi possível salvar a requisição.");
		}
	}
	
	public Usuario consultarUsuario(int codigo) throws UsuarioException {
		try {
			return manager.find(Usuario.class, codigo);
		} catch (RuntimeException e) {
			throw new UsuarioException("Erro ao consultar usuário.");
		}
	}

	
	public void excluirUsuario(int codigo) throws UsuarioException {
		
		try {
			manager.getTransaction().begin();
			manager.remove(getInstance().consultarUsuario(codigo));
			manager.getTransaction().commit();
		} catch (RuntimeException e) {
			throw new UsuarioException("Erro ao tentar excluir usuário!");
		}
		
	}
	
	public List<Usuario> consultarUsuario(String nome) throws UsuarioException {
		
		List<Usuario> usuarios;
		
		try {
			Query query = manager.createQuery("SELECT u FROM Usuario u WHERE nome = '" + nome + "'");
			usuarios = query.getResultList();
		} catch (RuntimeException e) {
			throw new UsuarioException("Erro ao tentar consultar usuários!");
		}
		
		return usuarios;
	}
	
	
	public List<Requisicao> consultarRequisicoes(Date data) {
		
		List<Requisicao> requisicoes = null;
		
		try {
			Query query = manager.createQuery("SELECT r FROM Requisicao r WHERE data = '" + data + "'");
			requisicoes = query.getResultList();
		} catch (RuntimeException e) {
			throw new RequisicaoException("Não foi possível consultar requisições a partir da data.");
		}
		
		return requisicoes;
	}
	
	public List<Requisicao> consultarRequisicoes(TipoRequisicao tipoRequisicao) {
		
		List<Requisicao> requisicoes = null;
		
		try {
			Query query = manager.createQuery("SELECT r FROM Requisicao r WHERE tipoRequisicao = '" + tipoRequisicao + "'");
			requisicoes = query.getResultList();
		} catch (RuntimeException e) {
			throw new RequisicaoException("Não foi possível consultar requisições a partir do tipo.");
		}
		
		return requisicoes;
	}
	
}
