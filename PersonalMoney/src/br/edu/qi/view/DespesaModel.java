/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author danie
 */
public class DespesaModel {
    private SimpleStringProperty usuario = new SimpleStringProperty();
    private SimpleStringProperty forma = new SimpleStringProperty();
    private SimpleStringProperty categoria = new SimpleStringProperty();
    private SimpleStringProperty data = new SimpleStringProperty();
    private SimpleDoubleProperty valor = new SimpleDoubleProperty();

    public String getUsuario() {
        return usuario.get();
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getForma() {
        return forma.get();
    }

    public void setForma(String forma) {
        this.forma.set(forma);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
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
