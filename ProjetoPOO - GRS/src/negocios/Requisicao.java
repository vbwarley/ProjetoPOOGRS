package negocios;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Requisicao {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoRequisicao tipoRequisicao;
	private int prazo;
	private Date data;
	
	@ManyToOne
	private Usuario usuario;
	
	private static final int PENDENTE = 1;
	private static final int ATENDIDA = 2;
	private Administrador adminRequisicao;
	private int status;
	
	public Requisicao() {
		
	}
	
	// setando tudo de inicio
	// usuario, novo parametro
	public Requisicao(String descricao, TipoRequisicao tipoRequisicao, int prazo, Usuario usuario) {
		this.descricao = descricao;
		this.tipoRequisicao = tipoRequisicao;
		this.prazo = prazo;
		this.usuario = usuario;
		this.data = new Date(Calendar.getInstance().getTimeInMillis());
		this.status = PENDENTE;
		
	}
	
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
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Administrador getAdminRequisicao() {
		return adminRequisicao;
	}

	public void setAdminRequisicao(Administrador adminRequisicao) {
		this.adminRequisicao = adminRequisicao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static int getPendente() {
		return PENDENTE;
	}

	public static int getAtendida() {
		return ATENDIDA;
	}

	@Override
	public String toString() {
		return "Código da requisição: " + codigo + "\nDescricao: " + descricao
				+ "\nTipo da Requisicao: " + tipoRequisicao + "\nPrazo: " + prazo
				+ "\nUsuario que requisitou: " + usuario.getNome() + "\n\n";
	}
	
	
	
}
