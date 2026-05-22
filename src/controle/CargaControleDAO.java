package controle;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Carga;

/**
 *
 * @author giov
 */
public class CargaControleDAO {

    public void adicionar(Carga carg) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(carg);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(Carga carg) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(carg);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public boolean excluir(int idCarga) {

        boolean achou = false;

        EntityManager gerente = GerenciadorConexao.getGerente();
        Carga carg = gerente.find(Carga.class, idCarga);

        if (carg != null) {
            gerente.getTransaction().begin();
            gerente.remove(carg);
            gerente.getTransaction().commit();

            achou = true;
        }

        gerente.close();
        return achou;
    }

    public boolean excluir(Carga carg) {
        return excluir(carg.getIdCarga());
    }

    public Carga getCargaPorId(int idCarga) {
    EntityManager em = GerenciadorConexao.getGerente();
    return em.find(Carga.class, idCarga);  // Isso busca a carga pelo ID no banco de dados
}

    
    public List<Carga> getTodos() {
        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.todos",
                Carga.class);

        return consulta.getResultList();
    }

    public List<Carga> getPorNomeCliente(String nomeCliente) {

        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.porNomeCliente",
                Carga.class);

        consulta.setParameter("nomeQualquer", "%" + nomeCliente + "%");

        return consulta.getResultList();
    }

    public void aprovar(Carga c) {
        Date data = new Date();
        c.setDataAprovacao(data);
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(c);
        gerente.getTransaction().commit();
        gerente.close();
    }
    
    // BUSCAR POR ID
    // FAZER O METODO AQUI
    //

    public List<Carga> getPorAprovado(){
        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.porAprovado",
                Carga.class);
        
        return consulta.getResultList();
    }
    
    public List<Carga> getPorPaga(String pesquisa){
        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.porPagaPesquisa",
                Carga.class);
        consulta.setParameter("pesquisa", "%"+pesquisa+"%");
        
        return consulta.getResultList();
    }
    
    public List<Carga> getPorNaoPaga(String pesquisa){
        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.porNaoPagaPesquisa",
                Carga.class);
        consulta.setParameter("pesquisa", "%"+pesquisa+"%");
        
        return consulta.getResultList();
    }
    
    public List<Carga> getPorPaga(){
        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.porPaga",
                Carga.class);
        
        return consulta.getResultList();
    }
    
    public List<Carga> getPorNaoPaga(){
        TypedQuery<Carga> consulta;
        EntityManager gerente = GerenciadorConexao.getGerente();

        consulta = gerente.createNamedQuery("Carga.porNaoPaga",
                Carga.class);
        
        return consulta.getResultList();
    }
    
    public List<Carga> getTodosOrdemCliente() {
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        List<Carga> listaCarga;
    
        TypedQuery<Carga> consultacarg = 
                gerente.createNamedQuery("Carga.todosOrdemCliente", Carga.class);
        
        listaCarga = consultacarg.getResultList();
        return listaCarga;
    }     
}
