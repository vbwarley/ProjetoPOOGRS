package excecoes;

public class RequisicaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Anexar uma causa ao erro ocorrido.
	 * @param e
	 */
	public RequisicaoException(Exception e){
		super(e);
	}
	
	/**
	 * Anexar uma mensagem e uma causa ao erro ocorrido.
	 * 
	 * @param msg
	 *            Mensagem que deve ser acrescentada no Stacktrace
	 * @param e
	 *            Causa do erro
	 */
	public RequisicaoException(String msg, Exception e) {
		super(msg, e);
	}
	
	/**
	 * Anexar uma mensagem ao erro ocorrido.
	 * 
	 * @param msg
	 *            Mensagem que deve ser acrescentada no Stacktrace
	 */
	public RequisicaoException(String msg) {
		super(msg, null);
	}
}
