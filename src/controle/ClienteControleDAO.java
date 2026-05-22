package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Cliente;

/**
 *
 * @author giov
 */
public class ClienteControleDAO {
    
    public void adicionar(Cliente cli){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        gerente.getTransaction().begin();
        
        gerente.persist(cli);
        
        gerente.getTransaction().commit();
        
        gerente.close();
    }
    
    public void alterar(Cliente cli){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        gerente.getTransaction().begin();
        
        gerente.merge(cli);
        
        gerente.getTransaction().commit();
        
        gerente.close();    
    }
    
    public boolean excluir(int idClinte){
    
        boolean achou = false;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        Cliente cli = gerente.find(Cliente.class, idClinte);
        
        if (cli != null)
        {  
            gerente.getTransaction().begin();

            gerente.remove(cli);

            gerente.getTransaction().commit();
            
            achou = true;
        }
        
        gerente.close();           
        return achou;
    }
    
    public boolean excluir(Cliente cli){
        return excluir(cli.getIdCliente());
    }
   
    
    public Cliente localizar(String nome){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        Cliente cli = gerente.find(Cliente.class, nome);
        
        gerente.close();
        
        return cli;
    } 
     
    public static List<Cliente> getPorNome(String nome){
        TypedQuery<Cliente> consulta;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        consulta = gerente.createNamedQuery("Cliente.porNome", 
                                             Cliente.class);
        consulta.setParameter("nomeprocurado", "%"+nome+"%");
                
        return consulta.getResultList();
    }    
    
    public static List<Cliente> getTodos(){
       
        TypedQuery<Cliente> consulta;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        consulta = gerente.createNamedQuery("Cliente.todas", 
                                             Cliente.class);
                
        return consulta.getResultList();
    }  
}
