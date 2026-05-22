package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author giov
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Produto.todas", query = "SELECT p FROM Produto p"),

    @NamedQuery(name = "Produto.porTipo",
            query = "SELECT p FROM Produto p WHERE p.tipo LIKE :tipoprocurado"
    )
})
@Table(name = "produto")
public class Produto implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProduto")
    private int idProduto;

    @Column(name = "tipo", length = 45, nullable = false)
    private String tipo;

    public Produto(int idProduto, String tipo) {
        this.idProduto = idProduto;
        this.tipo = tipo;
    }

    public Produto() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return this.idProduto == other.idProduto;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
    

}
