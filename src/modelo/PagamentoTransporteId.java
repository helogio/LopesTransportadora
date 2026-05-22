package modelo;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class PagamentoTransporteId  implements Serializable{
    
    private int idPagamentoTransporte;
    private int transporte;

    public PagamentoTransporteId() {
    }

    public int getIdPagamentoTransporte() {
        return idPagamentoTransporte;
    }

    public void setIdPagamentoTransporte(int idPagamentoTransporte) {
        this.idPagamentoTransporte = idPagamentoTransporte;
    }

    public int getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idPagamentoTransporte;
        hash = 73 * hash + this.transporte;
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
        final PagamentoTransporteId other = (PagamentoTransporteId) obj;
        if (this.idPagamentoTransporte != other.idPagamentoTransporte) {
            return false;
        }
        return this.transporte == other.transporte;
    }

    
}
