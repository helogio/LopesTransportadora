package modelo;

import java.io.Serializable;

/**
 *
 * @author giov
 */
public class TransporteId implements Serializable {

    private int carga;
    private int colaborador;
    
    public TransporteId() {
    }

    public TransporteId(int carga, int colaborador) {
        this.carga = carga;
        this.colaborador = colaborador;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getColaborador() {
        return colaborador;
    }

    public void setColaborador(int colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.carga;
        hash = 73 * hash + this.colaborador;
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
        final TransporteId other = (TransporteId) obj;
        if (this.carga != other.carga) {
            return false;
        }
        return this.colaborador == other.colaborador;
    }

}
