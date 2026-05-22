package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @NamedQuery(name = "Transporte.todos",
            query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.pesquisa", 
            query = "SELECT t FROM Transporte t JOIN t.carga ca JOIN t.colaborador co WHERE ca.origem LIKE :pesquisa OR ca.destino LIKE :pesquisa OR co.nome LIKE :pesquisa OR co.cpf LIKE :pesquisa OR ca.produto.tipo LIKE :pesquisa"),
    @NamedQuery(name = "Transporte.porFinalizado",
            query = "SELECT t FROM Transporte t WHERE t.dataDescarregou IS NOT NULL"),
    @NamedQuery(name = "Transporte.porEmAndamento",
            query = "SELECT t FROM Transporte t WHERE t.dataDescarregou IS NULL"),
    
    @NamedQuery(name = "Transporte.porFinalizadoPesquisa",
            query = "SELECT t FROM Transporte t JOIN t.colaborador co JOIN t.carga ca WHERE (co.nome LIKE :pesquisa OR ca.cliente.nome LIKE :pesquisa OR ca.produto.tipo LIKE :pesquisa) AND t.dataDescarregou IS NOT NULL"),
    @NamedQuery(name = "Transporte.porEmAndamentoPesquisa",
            query = "SELECT t FROM Transporte t JOIN t.colaborador co JOIN t.carga ca WHERE (co.nome LIKE :pesquisa OR ca.cliente.nome LIKE :pesquisa OR ca.produto.tipo LIKE :pesquisa) AND t.dataDescarregou IS NULL"),
    
    @NamedQuery(name = "Transporte.todosOrdemColab", 
            query = "SELECT t FROM Transporte t ORDER BY t.colaborador")
})


@Table(name = "transporte")
public class Transporte implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransporte")
    private int idTransporte;

    @ManyToOne
    @JoinColumn(name = "idCarga",
            referencedColumnName = "idCarga")
    private Carga carga;

    @ManyToOne
    @JoinColumn(name = "idColaborador",
            referencedColumnName = "idColaborador")
    private Colaborador colaborador;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCarregou")
    private Date dataCarregou;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataDescarregou")
    private Date dataDescarregou;

    @Column(name = "qtde", nullable = false)
    private double qtde;
    
    @Column(name = "valorFrete", nullable = false)
    private double valorFrete;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "Transporte")
    private List<PagamentoTransporte> pagamento = new ArrayList<>();
    
    public Transporte() {
    }

    public Transporte(int idTransporte, Carga carga, Colaborador colaborador, Date dataCarregou, Date dataDescarregou, double qtde, double valorFrete) {
        this.idTransporte = idTransporte;
        this.carga = carga;
        this.colaborador = colaborador;
        this.dataCarregou = dataCarregou;
        this.dataDescarregou = dataDescarregou;
        this.qtde = qtde;
        this.valorFrete = valorFrete;
    }    

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Date getDataCarregou() {
        return dataCarregou;
    }
    
    public String getDataCarregouFormatado(){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(this.dataCarregou);
    }

    public void setDataCarregou(Date dataCarregou) {
        this.dataCarregou = dataCarregou;
    }

    public Date getDataDescarregou() {
        return dataDescarregou;
    }

    public void setDataDescarregou(Date dataDescarregou) {
        this.dataDescarregou = dataDescarregou;
    }

    public boolean getIsPagamento(){
        boolean resposta = true;
        for(PagamentoTransporte p : this.pagamento){
            if(!p.getSituacaoPagamento().equals("__/__/____")){
               resposta = false;
            }
        }
        
        return resposta;
    }
    
    public String getSituacaoDescarregamento(){
        if(this.dataDescarregou == null){
            return "__/__/____";
        }else{
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            return formatoData.format(this.dataDescarregou);
        }
    }
    
    public String getPagouTudo(){
        String resposta = "Quitado";
        for(PagamentoTransporte p : this.pagamento){
            if(p.getDataPagamento() == null){
                resposta = "Pendente";
            }
        }
        
        return resposta;
    }
    
    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public List<PagamentoTransporte> getPagamento() {
        return pagamento;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public void setPagamento(List<PagamentoTransporte> pagamento) {
        this.pagamento = pagamento;
    }
     public void adicionarPagamento(PagamentoTransporte pt){
         pt.setTransporte(this);
         this.pagamento.add(pt);
     }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idTransporte;
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
        final Transporte other = (Transporte) obj;
        return this.idTransporte == other.idTransporte;
    }
}
