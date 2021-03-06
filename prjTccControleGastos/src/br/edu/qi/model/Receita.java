package br.edu.qi.model;
// Generated 29/10/2018 21:06:07 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Receita generated by hbm2java
 */
@Entity
@Table(name = "receita",
         catalog = "dbpersonalmoney"
)
public class Receita implements java.io.Serializable {

    private int idReceita;
    private int idCategoria;
    private int idUsuario;
    private String descricao;
    private double valor;
    private Date dataReceita;

    public Receita() {
    }

    public Receita(int idCategoria, int idUsuario, String descricao,
            double valor, Date dataReceita) {
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.descricao = descricao;
        this.valor = valor;
        this.dataReceita = dataReceita;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReceita", unique = true, nullable = false)
    public int getIdReceita() {
        return this.idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    @Column(name = "idCategoria", nullable = false)
    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Column(name = "idUsuario", nullable = false)
    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "descricao", nullable = false, length = 100)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "valor", nullable = false, precision = 22, scale = 0)
    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataReceita", nullable = false, length = 10)
    public Date getDataReceita() {
        return this.dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

}
