package negocios;

public class Requisicao {
	
	private int codigo;
	private String descricao;
	private TipoRequisicao tipoRequisicao;
	private int prazo;
	// novo atributo/classe 
	// rever o que colocar: se atributos, se classe
	//private Status status;
	private Usuario usuario;
	
	public Requisicao() {
		
	}
	
	// setando tudo de inicio
	// usuario, novo parametro
	public Requisicao(String descricao, TipoRequisicao tipoRequisicao, int prazo, Usuario usuario) {
		this.descricao = descricao;
		this.tipoRequisicao = tipoRequisicao;
		this.prazo = prazo;
		this.usuario = usuario;
	}
	
//	public String salvarRequisicao() {
//		return null;
//	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoRequisicao getTipoRequisicao() {
		return tipoRequisicao;
	}

	public void setTipoRequisicao(TipoRequisicao tipoRequisicao) {
		this.tipoRequisicao = tipoRequisicao;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Código da requisição: " + codigo + "\nDescricao: " + descricao
				+ "\nTipo da Requisicao: " + tipoRequisicao + "\nPrazo: " + prazo
				+ "\nUsuario que requisitou: " + usuario + "\n";
	}
	
	
	
}
