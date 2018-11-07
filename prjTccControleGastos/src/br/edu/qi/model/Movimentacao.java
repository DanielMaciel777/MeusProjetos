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
 * Movimentacao generated by hbm2java
 */
@Entity
@Table(name = "movimentacao",
        catalog = "dbpersonalmoney"
)
public class Movimentacao implements java.io.Serializable {

    private int idMovimentacao;
    private int idUsuario;
    private String tipoMovimentacao;
    private Integer idReceita;
    private Integer idDespesa;
    private double valorAnterior;
    private double valorAtual;
    private Date dataMovimentacao;

    public Movimentacao() {
    }

    public Movimentacao(int idUsuario, String tipoMovimentacao,
            double valorAnterior, double valorAtual, Date dataMovimentacao) {
        this.idUsuario = idUsuario;
        this.tipoMovimentacao = tipoMovimentacao;
        this.valorAnterior = valorAnterior;
        this.valorAtual = valorAtual;
        this.dataMovimentacao = dataMovimentacao;
    }

    public Movimentacao(int idUsuario, String tipoMovimentacao,
            Integer idReceita, Integer idDespesa, double valorAnterior,
            double valorAtual, Date dataMovimentacao) {
        this.idUsuario = idUsuario;
        this.tipoMovimentacao = tipoMovimentacao;
        this.idReceita = idReceita;
        this.idDespesa = idDespesa;
        this.valorAnterior = valorAnterior;
        this.valorAtual = valorAtual;
        this.dataMovimentacao = dataMovimentacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimentacao", unique = true, nullable = false)
    public int getIdMovimentacao() {
        return this.idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    @Column(name = "idUsuario", nullable = false)
    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "tipoMovimentacao", nullable = false, length = 7)
    public String getTipoMovimentacao() {
        return this.tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    @Column(name = "idReceita")
    public Integer getIdReceita() {
        return this.idReceita;
    }

    public void setIdReceita(Integer idReceita) {
        this.idReceita = idReceita;
    }

    @Column(name = "idDespesa")
    public Integer getIdDespesa() {
        return this.idDespesa;
    }

    public void setIdDespesa(Integer idDespesa) {
        this.idDespesa = idDespesa;
    }

    @Column(name = "valorAnterior", nullable = false, precision = 22, scale = 0)
    public double getValorAnterior() {
        return this.valorAnterior;
    }

    public void setValorAnterior(double valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    @Column(name = "valorAtual", nullable = false, precision = 22, scale = 0)
    public double getValorAtual() {
        return this.valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataMovimentacao", nullable = false, length = 10)
    public Date getDataMovimentacao() {
        return this.dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

}