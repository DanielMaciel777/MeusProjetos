/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author danie
 */
public class ReceitaModel {
    private SimpleIntegerProperty idReceita = new SimpleIntegerProperty();
    private SimpleBooleanProperty selecao = new SimpleBooleanProperty();
    private SimpleStringProperty categoria = new SimpleStringProperty();
    private SimpleStringProperty formaPagamento = new SimpleStringProperty();
    private SimpleStringProperty data = new SimpleStringProperty();
    private SimpleDoubleProperty valor = new SimpleDoubleProperty();

    public int getIdReceita() {
        return idReceita.get();
    }

    public void setIdReceita(int idReceita) {
        this.idReceita.set(idReceita);
    }
    
    

    public boolean getSelecao() {
        return selecao.get();
    }

    public void setSelecao(boolean selecao) {
        this.selecao.set(selecao);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public String getFormaPagamento() {
        return formaPagamento.get();
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento.set(formaPagamento);
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public double getValor() {
        return valor.get();
    }

    public void setValor(double valor) {
        this.valor.set(valor);
    }
    
    
}
