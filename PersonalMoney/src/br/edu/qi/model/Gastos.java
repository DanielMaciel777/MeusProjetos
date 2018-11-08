package br.edu.qi.model;
// Generated 07/11/2018 20:47:15 by Hibernate Tools 4.3.1


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
 * Gastos generated by hbm2java
 */
@Entity
@Table(name="gastos"
    ,catalog="dbpersonalmoney"
)
public class Gastos  implements java.io.Serializable {


     private Integer idGastos;
     private String categoria;
     private int idUsuario;
     private String descricao;
     private double valor;
     private Date dataGastos;

    public Gastos() {
    }

    public Gastos(String categoria, int idUsuario, String descricao, double valor, Date dataGastos) {
       this.categoria = categoria;
       this.idUsuario = idUsuario;
       this.descricao = descricao;
       this.valor = valor;
       this.dataGastos = dataGastos;
    }
   
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="idGastos", unique=true, nullable=false)
    public Integer getIdGastos() {
        return this.idGastos;
    }
    
    public void setIdGastos(Integer idGastos) {
        this.idGastos = idGastos;
    }

    
    @Column(name="categoria", nullable=false, length=20)
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    @Column(name="idUsuario", nullable=false)
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="descricao", nullable=false, length=100)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="valor", nullable=false, precision=22, scale=0)
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataGastos", nullable=false, length=10)
    public Date getDataGastos() {
        return this.dataGastos;
    }
    
    public void setDataGastos(Date dataGastos) {
        this.dataGastos = dataGastos;
    }




}


