/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

import br.edu.qi.model.Usuario;

/**
 *
 * @author danie
 */
public class Sessao {
   private static Sessao instance = null;
   private Usuario usuario;
   private Sessao(){
   }
   public void setUsuario(Usuario usuario){
      this.usuario = usuario;
   }
   public Usuario getUsuario(){
       return usuario;
   }
   public static Sessao getInstance(){
         if(instance == null){
               instance = new Sessao();
         }
        return instance;
   }
}
