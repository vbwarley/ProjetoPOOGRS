package negocios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import persistencia.Banco;

public class Fachada {
        
        // criando singleton
        private static Fachada instance = new Fachada();
        private UsuarioFactory factory = new UsuarioFactory();
        
        public Fachada() {
                
        }
        
        public static Fachada getInstance() {
                return instance;
        }
        
        public void enviarRequisicao(String descricaoRequisicao, int tipoRequisicao, int prazoParaTermino_dias, int codigoUsuario) {
                Usuario usuario = Usuario.consultarUsuario(codigoUsuario);
                        
                Requisicao requisicao = new Requisicao(descricaoRequisicao, getTipoRequisicao(tipoRequisicao), 
                                prazoParaTermino_dias, usuario);
                
                usuario.enviarRequisicao(requisicao);
        }
        
        public String consultarRequisicoes(Date data) {
                return Usuario.consultarRequisicao(data);
        
        }
        
        // essa implementação precisa ficar aqui mesmo
        public String consultarRequisicoes(int tipoRequisicao) {
                List<Requisicao> requisicoes;
        
                requisicoes = Banco.getInstance().consultarRequisicoes(getTipoRequisicao(tipoRequisicao));
                
                String requisicoesString = "";
                
                for (Requisicao r : requisicoes )
                        requisicoesString += r.toString() + "-*-";
                
                return requisicoesString;
        
        }
        
        public void criarUsuario(String nome, String departamento, String senha) {
                Usuario usuario = factory.criar(departamento);
                
                usuario.setNome(nome);
                usuario.setSenha(senha);
                
                usuario.salvarDados();
        }
        
        public String consultarUsuario(int codigo) {
                
                return Usuario.consultarUsuario(codigo).toString();
        }
        
        public String consultarUsuario(String nomeUsuario) {
                                
                return Usuario.consultarUsuario(nomeUsuario);
        }
        
        public void excluirUsuario(int codigoUsuario) {
                Administrador.excluirUsuario(codigoUsuario);
        }
        
        public String atualizarUsuario(int codigo, String nome, String departamento) {
                Usuario usuario = factory.criar(departamento);
                
                usuario.setCodigo(codigo);
                usuario.setNome(nome);
                usuario.setDepartamento(departamento);
                
                usuario.salvarDados();
                
                return usuario.toString();
        }
        
        // tipo de retorno alterado
        public int autenticacao(String nomeUsuario, String senha) {
                int codigo = Usuario.autenticar(nomeUsuario, senha);
                                
                return codigo;
        }
        
        public String mostrarDetalhesUsuario(int codigo) {
                return null;
        }
        
        // adicionado
        public TipoRequisicao getTipoRequisicao(int codigo) {
                return TipoRequisicao.values()[codigo-1];
        }
        
        // adicionado
        public String getTipoRequisicaoString() {
                String tipos = "";
                
                for (int i = 0; i < TipoRequisicao.values().length; i++) 
                        tipos += (i+1) + " " + TipoRequisicao.values()[i].toString() + "\n"; 
                
                return tipos;
        }
        
}