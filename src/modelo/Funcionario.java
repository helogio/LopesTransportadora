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
    @NamedQuery(name = "Funcionario.todas", query = "SELECT f FROM Funcionario f"),
   @NamedQuery(name = "Funcionario.porNome",query = "SELECT f FROM Funcionario f WHERE f.nome LIKE :nomeprocurado"),
    @NamedQuery(name = "Funcionario.Acessar", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf AND f.senha = :senha")
})

@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFuncionario")
    private int idFuncionario;

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

    @Column(name = "nivel", length = 1, nullable = false)
    private String nivel;

    @Column(name = "senha", length = 45, nullable = false)
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String cpf, String nome, String telefone, String email, String cidade, String estado, String bairro, String rua, String nivel, String senha) {
        this.idFuncionario = idFuncionario;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.nivel = nivel;
        this.senha = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    public String getNivelExtenso() {
        String retorno = "Funcionário";
        if (nivel.equals("A"))
            retorno = "Administrador";
        return retorno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idFuncionario;
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
        final Funcionario other = (Funcionario) obj;
        return this.idFuncionario == other.idFuncionario;
    }

}
