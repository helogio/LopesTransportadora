package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author giov
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Pagamento.todos",
            query = "SELECT pag FROM Pagamento pag"),
    @NamedQuery(name = "Pagamento.porCarga",
            query = "SELECT pag FROM Pagamento pag WHERE pag.carga.idCarga = :idCarga")
})

@Table(name = "pagamento")
public class Pagamento implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPagamento")
    private int idPagamento;
    
    @JoinColumn(name = "idCarga",
            referencedColumnName = "idCarga")
    
    @ManyToOne
    @JoinColumn(name = "idCarga",
            referencedColumnName = "idCarga")
    private Carga carga;
    
    @ManyToOne
    @JoinColumn(name = "idFuncionario",
            referencedColumnName = "idFuncionario")
    private Funcionario funcionario;

    @Column(name = "valorTotal", nullable = false)
    private double valorTotal;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataPagamento")
    private Date dataPagamento;
    

    public Pagamento() {
    }

    public Pagamento(int idPagamento, Carga carga, Funcionario funcionario, double valorTotal, Date dataPagamento) {
        this.idPagamento = idPagamento;
        this.carga = carga;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
        this.dataPagamento = dataPagamento;
    }
    
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.idPagamento;
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
        final Pagamento other = (Pagamento) obj;
        return this.idPagamento == other.idPagamento;
    }

}
