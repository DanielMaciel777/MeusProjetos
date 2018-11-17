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
import br.edu.qi.util.Sessao;
import java.util.List;

/**
 *
 * @author danie
 */
public class GanhosBO {
    List<Ganhos> listaGanhos;
    GanhosDao dao;
    TelaLoginEditController telaLogin = new TelaLoginEditController();
    Usuario usu = Sessao.getInstance().getUsuario();
    public GanhosBO(){
        dao = new GanhosDao();
        listaGanhos = dao.findAll();
    }
    
    public boolean existeGanhos(Ganhos gn) {
        listaGanhos = dao.findAll();
        for (Ganhos ganhos : listaGanhos) {
            if (ganhos.getDescricao().equals(gn.getDescricao())
                    &&ganhos.getCategoria().equals(gn.getCategoria())
                    &&ganhos.getDataGanhos().equals(gn.getDataGanhos())
                    &&ganhos.getFormaPagamento().equals(gn.getFormaPagamento())
                    &&ganhos.getValor()==gn.getValor()) {
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
            usu.setValorBanco(valorTotal);
        }
    }

    public List<Ganhos> listarGanhos() {
        listaGanhos = dao.findAll();
        return listaGanhos;
    }
    /*
    Se tiver sido alterado a forma de pagamento, altera-se o local que receberá 
    o dinheiro, se tiver sido alterado o valor(aumenta o valor em caso de que o novo valor
    seja maior que o antigo e diminui caso contrario), se ocorreu mudança na forma
    de pagamento e no valor recebido, então deve-se alterar os dois locais,outras alterações não 
    influenciam no restante do programa
    Este método terá 4 ifs
    */
    public void alterarGanhos(Ganhos gn, Ganhos antigo){
        if(gn.getFormaPagamento().equals(antigo.getFormaPagamento())){
            this.alterarFormaPagamento(gn.getFormaPagamento(), antigo.getValor());
        }
    }
    private void alterarFormaPagamento(String formaPagamento, double valor){
        double x = 0;
        if(formaPagamento.equals("dinheiro")){
            x = usu.getValorBanco();
            usu.setValorBanco(x-valor);
            usu.setValorCasa(usu.getValorCasa()+valor);
        }else{
            x=usu.getValorCasa();
            usu.setValorCasa(x-valor);
            usu.setValorBanco(usu.getValorBanco()+valor);
        }
    }
    private void alterarValorPago(double valor, String pagamento){
        if(pagamento.equals("dinheiro")){
            usu.setValorCasa(usu.getValorCasa()+(valor));
        }else{
            usu.setValorBanco(usu.getValorBanco()+(valor));
        }
    }
}
