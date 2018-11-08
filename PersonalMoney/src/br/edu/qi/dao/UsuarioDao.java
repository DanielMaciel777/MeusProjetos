/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author danie
 */
public class UsuarioDao extends GenericDao<Usuario, Serializable> {
    
    public UsuarioDao() {
        super(new Usuario());
    }
 
    public Usuario findByDesc(String desc) {

        if (desc == null) {
            return null;
        }

        List<Usuario> lista = (List<Usuario>) this.findAll();

        if (lista == null) {
            return null;
        }

        for (Usuario usuario : lista) {
            if (desc.equalsIgnoreCase(usuario.getNome())) {
                return usuario;
            }
        }

        return null;

    }

}