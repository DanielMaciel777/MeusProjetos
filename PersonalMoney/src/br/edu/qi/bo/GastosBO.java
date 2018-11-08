/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GastosDao;
import br.edu.qi.model.Gastos;
import java.util.List;

/**
 *
 * @author danie
 */
public class GastosBO {
    List<Gastos> listaGastos;
    GastosDao dao;
    
    public GastosBO(){
        dao = new GastosDao();
        listaGastos = dao.findAll();
    }
    
    public boolean existeGastos(Gastos gt) {
        listaGastos = dao.findAll();
        for (Gastos gastos : listaGastos) {
            if (gastos.getDescricao().equals(gt.getDescricao())) {
                return true;
            }
        }
        return false;
    }
    
    public void cadastrarGastos(Gastos gt) throws Exception {
        if (existeGastos(gt)) {
            throw new Exception("Gasto já informado");
        }

        dao.save(gt);
    }

    public List<Gastos> listarGastos() {
        listaGastos = dao.findAll();
        return listaGastos;
    }
}
