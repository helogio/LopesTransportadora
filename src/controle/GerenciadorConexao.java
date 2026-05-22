package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author giov
 */
public class GerenciadorConexao {
    
    private static EntityManagerFactory fabrica = null;
    
  
    public static EntityManagerFactory getFabrica()
    {
        if (fabrica == null) 
        {
            fabrica = Persistence.
                    createEntityManagerFactory("LTPU");
        }
        return fabrica;
    }
    
    public static EntityManager getGerente(){
        return getFabrica().createEntityManager();
    }
    
}
