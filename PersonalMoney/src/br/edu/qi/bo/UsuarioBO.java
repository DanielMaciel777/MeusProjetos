/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.UsuarioDao;
import br.edu.qi.model.Usuario;
import java.util.List;

/**
 *
 * @author danie
 */
public class UsuarioBO {
    List<Usuario> listaUsuario;
    UsuarioDao dao;
    
    public UsuarioBO(){
        dao = new UsuarioDao();
        listaUsuario = dao.findAll();
    }
    
    public boolean existeUsuario(Usuario u) {
        listaUsuario = dao.findAll();
        for (Usuario usuario : listaUsuario) {
            if (usuario.getNome().equals(u.getNome())) {
                return true;
            }
        }
        return false;
    }
    
    public void cadastrarUsuario(Usuario u) throws Exception {
        if (existeUsuario(u)) {
            throw new Exception("Usuário já cadastrado");
        }

        dao.save(u);
    }
    
    public void alterarUsuario(Usuario u) throws Exception{
        if(!existeUsuario(u)){
            throw new Exception("Usuário não existe");
        }
        dao.update(u);
    }

    public List<Usuario> listarUsuario() {
        listaUsuario = dao.findAll();
        return listaUsuario;
    }
    
    public void removerUsuario(Usuario u) throws Exception{
        if(!existeUsuario(u)){
            throw new Exception("Usuário não existe");
        }
        dao.delete(u);
    }
    public Usuario realizarLogin(String usuario,String senha){
        for (Usuario usu : listaUsuario) {
            if(usu.getNome().equals(usuario)&&usu.getSenha().equals(senha)){
                return usu;
            }
        }
        return null;
    }
}
