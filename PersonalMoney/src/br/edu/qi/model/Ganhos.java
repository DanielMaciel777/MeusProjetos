package br.edu.qi.model;
// Generated 07/11/2018 20:47:15 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ganhos generated by hbm2java
 */
@Entity
@Table(name="ganhos"
    ,catalog="dbpersonalmoney"
)
public class Ganhos  implements java.io.Serializable {


     private Integer idGanhos;
     private String categoria;
     private int idUsuario;
     private String descricao;
     private double valor;
     private Date dataGanhos;

    public Ganhos() {
    }

    public Ganhos(String categoria, int idUsuario, String descricao, double valor, Date dataGanhos) {
       this.categoria = categoria;
       this.idUsuario = idUsuario;
       this.descricao = descricao;
       this.valor = valor;
       this.dataGanhos = dataGanhos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idGanhos", unique=true, nullable=false)
    public Integer getIdGanhos() {
        return this.idGanhos;
    }
    
    public void setIdGanhos(Integer idGanhos) {
        this.idGanhos = idGanhos;
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
    @Column(name="dataGanhos", nullable=false, length=10)
    public Date getDataGanhos() {
        return this.dataGanhos;
    }
    
    public void setDataGanhos(Date dataGanhos) {
        this.dataGanhos = dataGanhos;
    }




}

