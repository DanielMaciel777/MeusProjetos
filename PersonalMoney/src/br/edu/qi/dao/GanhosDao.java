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
     public List<Ganhos> listarGanhosUsuario(){
         List<Ganhos> lista = (List<Ganhos>) this.findAll();
         List<Ganhos> listaUsuario = null;
         for (Ganhos ganhos : lista) {
             if(ganhos.getIdUsuario()==Sessao.getInstance().getUsuario().getIdUsuario()){
            listaUsuario.add(ganhos);
         }
}
         return listaUsuario;
     }
}