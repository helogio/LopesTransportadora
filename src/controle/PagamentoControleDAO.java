package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Pagamento;

/**
 *
 * @author giov
 */
public class PagamentoControleDAO {

    public void adicionar(Pagamento p) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(p);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(Pagamento p) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(p);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public boolean excluir(int idPagamento) {

        boolean achou = false;

        EntityManager gerente = GerenciadorConexao.getGerente();
        Pagamento p = gerente.find(Pagamento.class, idPagamento);

        if (p != null) {
            gerente.getTransaction().begin();
            gerente.remove(p);
            gerente.getTransaction().commit();

            achou = true;
        }

        gerente.close();
        return achou;
    }

    public boolean excluir(Pagamento p) {
        return excluir(p.getIdPagamento());
    }

    public List<Pagamento> getTodas() {
        TypedQuery<Pagamento> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Pagamento.todos",
                Pagamento.class);

        return consulta.getResultList();
    }
    
    public List<Pagamento> getPorCarga(int idCarga) {
        TypedQuery<Pagamento> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Pagamento.porCarga",
                Pagamento.class);
        consulta.setParameter("idCarga", idCarga);

        return consulta.getResultList();
    }
}
