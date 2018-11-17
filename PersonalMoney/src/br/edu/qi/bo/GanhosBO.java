/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.controller.TelaLoginEditController;
import br.edu.qi.dao.GanhosDao;
import br.edu.qi.model.Ganhos;
import br.edu.qi.model.Usuario;
import java.util.List;

/**
 *
 * @author danie
 */
public class GanhosBO {
    List<Ganhos> listaGanhos;
    GanhosDao dao;
    TelaLoginEditController telaLogin = new TelaLoginEditController();
    Usuario usu = telaLogin.getUsuarioLogado();
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
    /**
     * método usado para realizar o cadastro de um novo ganho
     * @param gn
     * @throws Exception 
     */
    public void cadastrarGanhos(Ganhos gn) throws Exception {
        if (existeGanhos(gn)) {
            throw new Exception("Ganho já informado");
        }
        dao.save(gn);
        atualizarSaldo(gn.getValor(), gn.getFormaPagamento());
        
    }
    /**
     * método para atualizar o saldo do usuário
     * @param valorGanho
     * @param formaPagamento 
     */
    private void atualizarSaldo(double valorGanho, String formaPagamento){
        double valorTotal=0;
        if(formaPagamento.equals("dinheiro")){
            valorTotal = usu.getValorCasa() + valorGanho;
            usu.setValorCasa(valorTotal);
        }else{
            valorTotal = usu.getValorBanco() + valorGanho;
        }
    }

    public List<Ganhos> listarGanhos() {
        listaGanhos = dao.findAll();
        return listaGanhos;
    }
    
    public void alterarGanhos(Ganhos atual,Ganhos novo){
        
    }
}
