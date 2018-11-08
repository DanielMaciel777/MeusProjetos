/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GanhosDao;
import br.edu.qi.model.Ganhos;
import java.util.List;

/**
 *
 * @author danie
 */
public class GanhosBO {
    List<Ganhos> listaGanhos;
    GanhosDao dao;
    
    public GanhosBO(){
        dao = new GanhosDao();
        listaGanhos = dao.findAll();
    }
    
    public boolean existeGanhos(Ganhos gn) {
        listaGanhos = dao.findAll();
        for (Ganhos ganhos : listaGanhos) {
            if (ganhos.getDescricao().equals(gn.getDescricao())) {
                return true;
            }
        }
        return false;
    }
    
    public void cadastrarGanhos(Ganhos gn) throws Exception {
        if (existeGanhos(gn)) {
            throw new Exception("Ganho já informado");
        }

        dao.save(gn);
    }

    public List<Ganhos> listarGanhos() {
        listaGanhos = dao.findAll();
        return listaGanhos;
    }
}
