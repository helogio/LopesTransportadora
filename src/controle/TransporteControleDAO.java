package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Transporte;

/**
 *
 * @author giov
 */
public class TransporteControleDAO {

    public void adicionar(Transporte t) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(t);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Transporte t) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(t);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public boolean excluir(int idTransporte) {

        boolean achou = false;

        EntityManager gerente = GerenciadorConexao.getGerente();

        Transporte t = gerente.find(Transporte.class, idTransporte);

        if (t != null) {
            gerente.getTransaction().begin();

            gerente.remove(t);

            gerente.getTransaction().commit();

            achou = true;
        }

        gerente.close();
        return achou;
    }

    public boolean excluir(Transporte t) {
        return excluir(t.getIdTransporte());
    }

    public Transporte localizar(String idTransporte) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        Transporte t = gerente.find(Transporte.class, idTransporte);

        gerente.close();

        return t;
    }

    public List<Transporte> getTodos() {

        TypedQuery<Transporte> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Transporte.todos",
                Transporte.class);

        return consulta.getResultList();
    }
    
    public List<Transporte> getPesquisa(String pesquisa) {

        TypedQuery<Transporte> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Transporte.pesquisa",
                Transporte.class);
        consulta.setParameter("pesquisa", "%"+pesquisa+"%");

        return consulta.getResultList();
    }
    
    public List<Transporte> getPorFinalizado() {

        TypedQuery<Transporte> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Transporte.porFinalizado",
                Transporte.class);

        return consulta.getResultList();
    }
    
    public List<Transporte> getPorEmAndamento() {

        TypedQuery<Transporte> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Transporte.porEmAndamento",
                Transporte.class);

        return consulta.getResultList();
    }
    
    public List<Transporte> getPorFinalizadoPesquisa(String pesquisa) {

        TypedQuery<Transporte> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Transporte.porFinalizadoPesquisa",
                Transporte.class);
        consulta.setParameter("pesquisa", "%"+pesquisa+"%");
        return consulta.getResultList();
    }
    
    public List<Transporte> getPorEmAndamentoPesquisa(String pesquisa) {

        TypedQuery<Transporte> consulta;

        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Transporte.porEmAndamentoPesquisa",
                Transporte.class);
        consulta.setParameter("pesquisa", "%"+pesquisa+"%");
        return consulta.getResultList();
    }
    
    public List<Transporte> getTodosOrdemColab() {
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        List<Transporte> listaTransporte;
    
        TypedQuery<Transporte> consultatrans = 
                gerente.createNamedQuery("Transporte.todosOrdemColab", Transporte.class);
        
        listaTransporte = consultatrans.getResultList();
        return listaTransporte;
    }     
}
