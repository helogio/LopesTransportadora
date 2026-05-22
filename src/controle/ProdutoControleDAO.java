package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Produto;

/**
 *
 * @author giov
 */
public class ProdutoControleDAO {
    
    public void adicionar(Produto p){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        gerente.getTransaction().begin();
        
        gerente.persist(p);
        
        gerente.getTransaction().commit();
        
        gerente.close();
    }
    
    public void alterar(Produto p){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        gerente.getTransaction().begin();
        
        gerente.merge(p);
        
        gerente.getTransaction().commit();
        
        gerente.close();    
    }
    
    public boolean excluir(int idProduto){
    
        boolean achou = false;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        Produto p = gerente.find(Produto.class, idProduto);
        
        if (p != null)
        {  
            gerente.getTransaction().begin();

            gerente.remove(p);

            gerente.getTransaction().commit();
            
            achou = true;
        }
        
        gerente.close();           
        return achou;
    }
    
    public boolean excluir(Produto p){
        return excluir(p.getIdProduto());
    }
   
    
    public Produto localizar(String tipo){
        EntityManager gerente = GerenciadorConexao.getGerente();
   
        Produto p = gerente.find(Produto.class, tipo);
        
        gerente.close();
        
        return p;
    } 
     public List<Produto> getPorTipo(String tipo){
        TypedQuery<Produto> consulta;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        consulta = gerente.createNamedQuery("Produto.porTipo", 
                                             Produto.class);
        consulta.setParameter("tipoprocurado", "%"+tipo+"%");
                
        return consulta.getResultList();
    }
     
    public static List<Produto> getTodos(){
       
        TypedQuery<Produto> consulta;
        
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        consulta = gerente.createNamedQuery("Produto.todas", 
                                             Produto.class);
                
        return consulta.getResultList();
    }  
}
