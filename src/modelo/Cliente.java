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
    @NamedQuery(name = "Cliente.todas", query = "SELECT cli FROM Cliente cli"),

    @NamedQuery(name = "Cliente.porNome",
            query = "SELECT cli FROM Cliente cli WHERE cli.nome LIKE :nomeprocurado"
    )
})
@Table(name = "cliente")
public class Cliente implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCliente")
    private int idCliente;

    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Column(name = "nome", length = 45, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "cidade", length = 45, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Column(name = "bairro", length = 45, nullable = false)
    private String bairro;
    
    @Column(name = "rua", length = 45, nullable = false)
    private String rua;

    public Cliente() {
    }
    
    public Cliente(int idCliente, String cpf, String nome, String telefone, String email, String cidade, String estado, String bairro, String rua) {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idCliente;
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
        final Cliente other = (Cliente) obj;
        return this.idCliente == other.idCliente;
    }

}
