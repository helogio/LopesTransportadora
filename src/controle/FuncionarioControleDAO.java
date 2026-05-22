package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Funcionario;

/**
 *
 * @author giov
 */
public class FuncionarioControleDAO {

    public void adicionar(Funcionario f) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(f);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Funcionario f) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(f);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public boolean excluir(int idFuncionario) {

        boolean achou = false;

        EntityManager gerente = GerenciadorConexao.getGerente();

        Funcionario f = gerente.find(Funcionario.class, idFuncionario);

        if (f != null) {
            gerente.getTransaction().begin();

            gerente.remove(f);

            gerente.getTransaction().commit();

            achou = true;
        }

        gerente.close();
        return achou;
    }

    public boolean excluir(Funcionario f) {
        return excluir(f.getIdFuncionario());
    }

    public Funcionario localizar(String nome) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        Funcionario f = gerente.find(Funcionario.class, nome);

        gerente.close();

        return f;
    }

    public List<Funcionario> getTodos() {

        TypedQuery<Funcionario> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Funcionario.todas",
                Funcionario.class);

        return consulta.getResultList();
    }

    public static List<Funcionario> getPorNome(String nome) {
        TypedQuery<Funcionario> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Funcionario.porNome",
                Funcionario.class);
        consulta.setParameter("nomeprocurado", "%" + nome + "%");

        return consulta.getResultList();
    }

    //PARTE DO LOGIN
    private static Funcionario funcLogado = null;

    public static Funcionario getFuncLogado() {
        return funcLogado;
    }

    public static boolean isFuncLogado() {
        return funcLogado != null;
    }

    public static void logoutFunc() {
        FuncionarioControleDAO.funcLogado = null;
    }

    public static boolean logarFuncionario(String cpf, String senha) {

        boolean logou = false;

        EntityManager gerente = GerenciadorConexao.getGerente();

        List<Funcionario> listaFunc;

        TypedQuery<Funcionario> consultaFunc
                = gerente.createNamedQuery("Funcionario.Acessar", Funcionario.class);

        consultaFunc.setParameter("cpf", cpf);
        consultaFunc.setParameter("senha", senha);

        listaFunc = consultaFunc.getResultList();

        if (listaFunc.isEmpty()) {
            FuncionarioControleDAO.funcLogado = null;

        } else {
            FuncionarioControleDAO.funcLogado = listaFunc.get(0);
            logou = true;
        }

        return logou;
    }
}
