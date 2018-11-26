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
import java.util.List;

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
        listaGanhos = dao.findAll();
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
    public void cadastrarGanhos(Ganhos gn) throws Exception {
        if (existeGanhos(gn)) {
            throw new Exception("Ganho já informado");
        }
        dao.save(gn);
        atualizarSaldo(gn.getValor(), gn.getFormaPagamento());

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
        listaGanhos = dao.findAll();
        return listaGanhos;
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
        double x = 0;
        if (formaPagamento.equals("dinheiro")) {
            x = usu.getValorBanco();
            usu.setValorBanco(x - valor);
            usu.setValorCasa(usu.getValorCasa() + valor);
        } else {
            x = usu.getValorCasa();
            usu.setValorCasa(x - valor);
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
}
