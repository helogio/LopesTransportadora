package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.PagamentoTransporte;

/**
 *
 * @author giov
 */
public class PagamentoTransporteControleDAO {

    public void adicionar(PagamentoTransporte pg) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(pg);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(PagamentoTransporte pg) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(pg);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public boolean excluir(int idPagamentoTransporte) {

        boolean achou = false;

        EntityManager gerente = GerenciadorConexao.getGerente();
        PagamentoTransporte pg = gerente.find(PagamentoTransporte.class, idPagamentoTransporte);

        if (pg != null) {
            gerente.getTransaction().begin();
            gerente.remove(pg);
            gerente.getTransaction().commit();

            achou = true;
        }

        gerente.close();
        return achou;
    }

    public boolean excluir(PagamentoTransporte pt) {
        return excluir(pt.getIdPagamentoTransporte());
    }

    public List<PagamentoTransporte> getTodas() {
        TypedQuery<PagamentoTransporte> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("PagamentoTransporte.todos",
                PagamentoTransporte.class);

        return consulta.getResultList();
    }
    
    public List<PagamentoTransporte> getPorIdTransporte(int id) {
        TypedQuery<PagamentoTransporte> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("PagamentoTransporte.porIdTransporte",
                PagamentoTransporte.class);
        
        consulta.setParameter("id", id);

        return consulta.getResultList();
    }
}
