/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.controller.TelaLoginEditController;
import br.edu.qi.dao.GanhosDao;
import br.edu.qi.dao.UsuarioDao;
import br.edu.qi.model.Ganhos;
import br.edu.qi.model.Usuario;
import br.edu.qi.util.Sessao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Daniel de Abreu Maciel
 * @version 2.0
 * @since 17/11/2018
 */
public class GanhosBO {

    List<Ganhos> listaGanhos;
    GanhosDao dao;
    UsuarioDao usuDao;
    //TelaLoginEditController telaLogin = new TelaLoginEditController();
    Usuario usu = Sessao.getInstance().getUsuario();

    public GanhosBO() {
        dao = new GanhosDao();
        listaGanhos = dao.listarGanhos();
        usuDao = new UsuarioDao();
    }

    public boolean existeGanhos(Ganhos gn) {
        listaGanhos = dao.findAll();
        for (Ganhos ganhos : listaGanhos) {
            if (ganhos.getDescricao().equals(gn.getDescricao())
                    && ganhos.getCategoria().equals(gn.getCategoria())
                    && ganhos.getDataGanhos().equals(gn.getDataGanhos())
                    && ganhos.getFormaPagamento().equals(gn.getFormaPagamento())
                    && ganhos.getValor() == gn.getValor()) {
                return true;
            }
        }

        return false;
    }

    /**
     * método usado para realizar o cadastro de um novo ganho
     *
     * @param gn
     * @throws Exception
     */
    public int cadastrarGanhos(Ganhos gn) throws Exception {
        if (existeGanhos(gn)) {
            throw new Exception("Ganho já informado");
        }
        dao.save(gn);
        atualizarSaldo(gn.getValor(), gn.getFormaPagamento());
        int idReceita= dao.getIdGanho(gn);
        return idReceita;
    }

    /**
     * método para atualizar o saldo do usuário
     *
     * @param valorGanho
     * @param formaPagamento
     */
    private void atualizarSaldo(double valorGanho, String formaPagamento) throws Exception {
        double valorTotal = 0;
        if (formaPagamento.equals("dinheiro")) {
            valorTotal = usu.getValorCasa() + valorGanho;
            usu.setValorCasa(valorTotal);
        } else {
            valorTotal = usu.getValorBanco() + valorGanho;
            usu.setValorBanco(valorTotal);
        }
        usuDao.update(usu);
    }

    public List<Ganhos> listarGanhos() {
        List<Ganhos> list = new ArrayList<>();
        listaGanhos = dao.listarGanhos();
        for (Ganhos ganho : listaGanhos) {
            if(ganho.getIdUsuario()==usu.getIdUsuario()){
                 list.add(ganho);
            }
        }
         return list;
          }           

    public void alterarGanhos(Ganhos gn, Ganhos antigo) throws Exception {
        if (!gn.getFormaPagamento().equals(antigo.getFormaPagamento()) && gn.getValor() != antigo.getValor()) {
            this.alterarFormaPagamento(gn.getFormaPagamento(), antigo.getValor());
            this.alterarValorRecebido(gn.getValor(), gn.getFormaPagamento(), antigo.getValor());
        } else if (gn.getFormaPagamento().equals(antigo.getFormaPagamento()) && gn.getValor() != antigo.getValor()) {
            this.alterarValorRecebido(gn.getValor(), gn.getFormaPagamento(), antigo.getValor());
        } else if (!gn.getFormaPagamento().equals(antigo.getFormaPagamento()) && gn.getValor() == antigo.getValor()) {
            this.alterarFormaPagamento(gn.getFormaPagamento(), antigo.getValor());
        }
        dao.update(gn);
    }

    private void alterarFormaPagamento(String formaPagamento, double valor) throws Exception {
        double valorRecebido = 0;
        if (formaPagamento.equals("dinheiro")) {
            valorRecebido = usu.getValorBanco();
            usu.setValorBanco(valorRecebido - valor);
            usu.setValorCasa(usu.getValorCasa() + valor);
        } else {
            valorRecebido = usu.getValorCasa();
            usu.setValorCasa(valorRecebido - valor);
            usu.setValorBanco(usu.getValorBanco() + valor);
        }
        usuDao.update(usu);
    }

    private void alterarValorRecebido(double valor, String pagamento, double valorAntigo) throws Exception {
        double diferenca = valor - valorAntigo;
        if (pagamento.equals("dinheiro")) {
            usu.setValorCasa(usu.getValorCasa() + (diferenca));
        } else {
            usu.setValorBanco(usu.getValorBanco() + (diferenca));
        }
        usuDao.update(usu);
    }
    public Ganhos buscaId(int id){
        return dao.findByCod(id);
    }
    public void removerGanho(Ganhos ganho) throws Exception{
        listaGanhos = dao.listarGanhos();
        for (Ganhos listaGanho : listaGanhos) {
            if(listaGanho.getIdGanhos()==ganho.getIdGanhos()){
                dao.delete(ganho);
            }
        }
    }
}
