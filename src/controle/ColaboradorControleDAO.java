package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Colaborador;

/**
 *
 * @author giov
 */
public class ColaboradorControleDAO {
    
    public void adicionar(Colaborador c){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        gerente.getTransaction().begin();
        
        gerente.persist(c);
        
        gerente.getTransaction().commit();
        
        gerente.close();
    }
    
    public void alterar(Colaborador c){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        gerente.getTransaction().begin();
        
        gerente.merge(c);
        
        gerente.getTransaction().commit();
        
        gerente.close();    
    }
    
    public boolean excluir(int idColaborador){
    
        boolean achou = false;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        Colaborador c = gerente.find(Colaborador.class, idColaborador);
        
        if (c != null)
        {  
            gerente.getTransaction().begin();

            gerente.remove(c);

            gerente.getTransaction().commit();
            
            achou = true;
        }
        
        gerente.close();           
        return achou;
    }
    
    public boolean excluir(Colaborador c){
        return excluir(c.getIdColaborador());
    }
   
    public static List<Colaborador> getPorNome(String nome){
        TypedQuery<Colaborador> consulta;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        consulta = gerente.createNamedQuery("Colaborador.porNome", 
                                             Colaborador.class);
        consulta.setParameter("nomeprocurado", "%"+nome+"%");
                
        return consulta.getResultList();
    }    
    
    public static List<Colaborador> getTodos(){
       
        TypedQuery<Colaborador> consulta;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        consulta = gerente.createNamedQuery("Colaborador.todos", 
                                             Colaborador.class);
                
        return consulta.getResultList();
    }  
}
