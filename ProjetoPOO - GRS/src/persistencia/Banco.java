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
		// rever a utilização dessa mensagem
		String mensagem = "Usuário cadastrado com sucesso!";
		return mensagem;
	}
	
	public String salvarRequisicao(Requisicao requisicao) {
		// impelementado
		manager.getTransaction().begin();
		manager.persist(requisicao);
		manager.getTransaction().commit();
		
		return null;
	}
	
	// novo método adicionado
	public Usuario consultarUsuario(int codigo) {
		
		// não precisa abrir conexão
		manager.getTransaction().begin();
		Usuario u = manager.find(Usuario.class, codigo);
		// nem commitar
		manager.getTransaction().commit();
		return u;
	}
	
	public String atualizarUsuario(Usuario usuario){
		
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		
		String mensagem = "Usuario atualizado no banco de dados. Novas informações: \n " + usuario.toString();
		
		return mensagem;
	}
	
	public String excluirUsuario(int codigo) {
		manager.getTransaction().begin();
		manager.remove(getInstance().consultarUsuario(codigo));
		manager.getTransaction().commit();
		// e se o usuario não foi excluído? se deu erro, não se deve retornar essa mensagem
		return "Usuario excluído com sucesso!";
	}
	
	public Collection<Usuario> consultarUsuarios(String nome) {
		
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE nome = '" + nome);
		
		// teste
		List<Usuario> usuarios = query.getResultList();
		
		return usuarios;
		
	}
	
	// mudança no parametro
	// analisar
	public Collection<Requisicao> consultarRequisicoes(Date data) {
		
		Query query = manager.createQuery("SELECT r FROM Requisicao r WHERE data = '" + data + "'");
		Collection<Requisicao> requisicoes = query.getResultList();
		
		return requisicoes;
	}
	
	public Collection<Requisicao> consultarRequisicoes(TipoRequisicao tipoRequisicao) {
		// falta implementar
		return null;
	}
	
}
