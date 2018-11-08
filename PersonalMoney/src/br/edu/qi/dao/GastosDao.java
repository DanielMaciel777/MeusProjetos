/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Gastos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author danie
 */
public class GastosDao extends GenericDao<Gastos, Serializable> {
    
    public GastosDao() {
        super(new Gastos());
    }
    
    public Gastos findByDesc(String desc) {

        if (desc == null) {
            return null;
        }

        List<Gastos> lista = (List<Gastos>) this.findAll();

        if (lista == null) {
            return null;
        }

        for (Gastos gastos : lista) {
            if (desc.equalsIgnoreCase(gastos.getDescricao())) {
                return gastos;
            }
        }

        return null;

    }

    
}
