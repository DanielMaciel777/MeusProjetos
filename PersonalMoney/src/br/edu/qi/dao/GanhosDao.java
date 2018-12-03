/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Ganhos;
import br.edu.qi.util.Sessao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author danie
 */
public class GanhosDao extends GenericDao<Ganhos, Serializable> {
    
    public GanhosDao() {
        super(new Ganhos());
    }
    public Ganhos findByDesc(String desc) {

        if (desc == null) {
            return null;
        }

        List<Ganhos> lista = (List<Ganhos>) this.findAll();

        if (lista == null) {
            return null;
        }

        for (Ganhos ganhos : lista) {
            if (desc.equalsIgnoreCase(ganhos.getDescricao())) {
                return ganhos;
            }
        }

        return null;

    }
     public List<Ganhos> listarGanhos(){
         List<Ganhos> lista = (List<Ganhos>) this.findAll();
          return lista;
     }
     public int getIdGanho(Ganhos ganho){
        List<Ganhos> lista = listarGanhos();
         for (Ganhos g : lista) {
             if(ganho.getDescricao().equals(g.getDescricao())
                     &&ganho.getValor()==g.getValor()
                     &&ganho.getCategoria().equals(g.getCategoria())){
                 return g.getIdGanhos();
         }
            
     }
          return -1;
}
}
