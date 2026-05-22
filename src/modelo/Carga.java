package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author giov
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Carga.todos",
            query = "SELECT c FROM Carga c"),
    
     @NamedQuery(name = "Carga.porIdCarga", 
             query = "SELECT c FROM Carga c WHERE c.idCarga = :idCarga"),

    @NamedQuery(name = "Carga.porNomeCliente",
            query = "SELECT c FROM Carga c WHERE c.cliente.nome LIKE :nomeQualquer"),
     
    @NamedQuery(name = "Carga.porAprovado",
            query = "SELECT c FROM Carga c WHERE c.dataAprovacao IS NOT NULL AND c.qtdeTransportada < c.qtdeTotal"),
    
    @NamedQuery(name = "Carga.porPagaPesquisa",
            query = "SELECT c FROM Carga c JOIN c.cliente cl JOIN c.produto p WHERE (cl.nome LIKE :pesquisa OR p.tipo LIKE :pesquisa OR c.origem LIKE :pesquisa OR c.destino LIKE :pesquisa) AND c.dataAprovacao IS NOT NULL"),
        
    @NamedQuery(name = "Carga.porNaoPagaPesquisa",
            query = "SELECT c FROM Carga c JOIN c.cliente cl JOIN c.produto p WHERE (cl.nome LIKE :pesquisa OR p.tipo LIKE :pesquisa OR c.origem LIKE :pesquisa OR c.destino LIKE :pesquisa) AND c.dataAprovacao IS NULL"),
    
    @NamedQuery(name = "Carga.porPaga",
            query = "SELECT c FROM Carga c WHERE c.dataAprovacao IS NOT NULL"),
        
    @NamedQuery(name = "Carga.porNaoPaga",
             query = "SELECT c FROM Carga c WHERE c.dataAprovacao IS NULL"),
    
     @NamedQuery(name = "Carga.todosOrdemCliente", 
            query = "SELECT c FROM Carga c ORDER BY c.cliente")

        
})

@Table(name = "carga")
public class Carga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarga")
    private int idCarga;

    @ManyToOne
    @JoinColumn(name = "idCliente",
            referencedColumnName = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProduto",
            referencedColumnName = "idProduto")
    private Produto produto;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataAprovacao")
    private Date dataAprovacao;

    @Column(name = "origem", length = 45, nullable = false)
    private String origem;

    @Column(name = "destino", length = 45, nullable = false)
    private String destino;

    @Column(name = "qtdeTotal", nullable = false)
    private double qtdeTotal;

    @Column(name = "valorCarga", nullable = false)
    private double valorCarga;

    @Column(name = "unidadeMedida", length = 20, nullable = false)
    private String unidadeMedida;

    @Column(name = "qtdeTransportada", nullable = false)
    private double qtdeTransportada;
    
    @OneToMany(cascade = CascadeType.REFRESH, 
               mappedBy = "carga")
    private List<Pagamento> pagamentos;
    
    @OneToMany(cascade = CascadeType.REFRESH, 
               mappedBy = "carga")
    private List<Transporte> transportes;
    
    public Carga() {
    }

    public Carga(int idCarga, Cliente cliente, Produto produto, Date dataAprovacao, String origem, String destino, double qtdeTotal, double valorCarga, String unidadeMedida, double qtdeTransportada) {
        this.idCarga = idCarga;
        this.cliente = cliente;
        this.produto = produto;
        this.dataAprovacao = dataAprovacao;
        this.origem = origem;
        this.destino = destino;
        this.qtdeTotal = qtdeTotal;
        this.valorCarga = valorCarga;
        this.unidadeMedida = unidadeMedida;
        this.qtdeTransportada = qtdeTransportada;
    }

    public int getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(int idCarga) {
        this.idCarga = idCarga;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getQtdeTotal() {
        return qtdeTotal;
    }

    public void setQtdeTotal(double qtdeTotal) {
        this.qtdeTotal = qtdeTotal;
    }

    public double getValorCarga() {
        return valorCarga;
    }
    
    public double getValorCargaLevada(double qtdLevada) {
        return qtdLevada*valorCarga/qtdeTotal;
    }

    public void setValorCarga(double valorCarga) {
        this.valorCarga = valorCarga;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getQtdeTransportada() {
        return qtdeTransportada;
    }

    public void setQtdeTransportada(double qtdeTransportada) {
        this.qtdeTransportada = qtdeTransportada;
    }

     public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }
    
    public String getSituacao()
    {
       if(this.dataAprovacao != null) {
            return "Aprovada";
        } else {
            return "Em analise";
        }
    }
    
    public double getQuantRestante(){
        return this.getQtdeTotal() - this.getQtdeTransportada();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idCarga;
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
        final Carga other = (Carga) obj;
        return this.idCarga == other.idCarga;
    }

 
    
    
}
