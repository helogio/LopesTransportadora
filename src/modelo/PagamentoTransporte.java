package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author giov
 */
@Entity
@Table(name = "pagamentoTransporte")
@NamedQueries({
    @NamedQuery(name = "PagamentoTransporte.todos",
            query = "SELECT pt FROM PagamentoTransporte pt"),
    @NamedQuery(name = "PagamentoTransporte.porIdTransporte", 
            query = "SELECT pt FROM PagamentoTransporte pt WHERE pt.transporte.idTransporte = :id")

})

@IdClass(PagamentoTransporteId.class)
public class PagamentoTransporte implements Serializable {

    @Id
    @Column(name = "idPagamentoTransporte") 
    private int idPagamentoTransporte;

    @Id
    @ManyToOne
    @JoinColumn(name = "idTransporte",
            referencedColumnName = "idTransporte")
    private Transporte transporte;

    @Column(name = "valorParcela", nullable = false)
    private double valorParcela;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataVencimento", nullable = false)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataPagamento")
    private Date dataPagamento;

    public PagamentoTransporte() {
    }

    public PagamentoTransporte(int idPagamentoTransporte, Transporte transporte, double valorParcela, Date dataVencimento, Date dataPagamento) {
        this.idPagamentoTransporte = idPagamentoTransporte;
        this.transporte = transporte;
        this.valorParcela = valorParcela;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public int getIdPagamentoTransporte() {
        return idPagamentoTransporte;
    }

    public void setIdPagamentoTransporte(int idPagamentoTransporte) {
        this.idPagamentoTransporte = idPagamentoTransporte;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }
    
    public String getDataVencimentoFormatado(){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(this.dataVencimento);
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public String getSituacaoPagamento(){
        if(this.dataPagamento == null){
            return "__/__/____";
        }else{
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            return formatoData.format(this.dataPagamento);
        }
    }
   
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idPagamentoTransporte;
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
        final PagamentoTransporte other = (PagamentoTransporte) obj;
        return this.idPagamentoTransporte == other.idPagamentoTransporte;
    }
}
