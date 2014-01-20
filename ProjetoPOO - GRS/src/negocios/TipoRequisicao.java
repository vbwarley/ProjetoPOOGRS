package negocios;

import javax.persistence.Entity;

// tipos de requisições
@Entity
public enum TipoRequisicao {
	AJUDA, MANUTENCAO, SUPORTE, AUMENTO_DE_BANDA_DA_INTERNET
}
