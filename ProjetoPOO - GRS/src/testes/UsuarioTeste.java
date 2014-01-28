package testes;

import static junit.framework.Assert.*;
import negocios.Administrador;
import negocios.Cliente;
import negocios.Fachada;
import negocios.Requisicao;
import negocios.Usuario;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTeste {
	  
	private Usuario a;
	private Usuario c;
	
	@Before
	public void setUp() throws Exception{
		a = new Administrador();
		c = new Cliente();
	}
	
	@Test
	public void testSalvarAdministrador() {
		a.setNome("Lucas");
		a.setSenha("Lindo!");
		a.salvarDados();
		assertNotNull(a.getCodigo());
	}

	@Test
	public void testEnviarRequisicao() {
		c.salvarDados();
		Requisicao r = new Requisicao();
		r.setDescricao("Teste");
		a.enviarRequisicao(r);
		assertNotNull(r.getCodigo());
	}
	
	@Test
	public void testSalvarCliente(){
		c.setNome("Warley");
		c.setSenha("Afeminado");
		c.salvarDados();
		assertNotNull(c.getCodigo());
	}
	
	@Test
	public void testExcluirUsuario(){
		c.setNome("Warley");
		c.setSenha("Afeminado");
		c.salvarDados();
		assertNotNull(c.getCodigo());
		Fachada.getInstance().excluirUsuario(c.getCodigo());
		assertNull(c);
	}
	
	@Test
	public void testAtualizarUsuario(){
		c.setNome("Douglas");
		c.setSenha("corDeRosa");
		c.salvarDados();
		assertNotNull(c.getCodigo());
		Usuario c1 = new Cliente();
		c1 = c;
		Fachada.getInstance().atualizarUsuario(c.getCodigo(), "Dodo", "Algum");
		assertEquals(c, c1);
	}
	
	@Test
	public void testAutenticarUsuario(){
		a.setNome("Lukinhas");
		a.setSenha("Alguma");
		a.salvarDados();
		assertNotNull(a.getCodigo());
		int codigo = Fachada.getInstance().autenticacao(a.getNome(), a.getSenha());
		assertEquals(a.getCodigo(), codigo);
	}
	
	@Test
	public void testConsultarUsuario(){
		a.setNome("Lukinhas");
		a.setSenha("Alguma");
		a.salvarDados();
		assertNotNull(a.getCodigo());
		String b = a.toString();
		assertEquals(b,Fachada.getInstance().consultarUsuario(a.getCodigo()));
	}

}
