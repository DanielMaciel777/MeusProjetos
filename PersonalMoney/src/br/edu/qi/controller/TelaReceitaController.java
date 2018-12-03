/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.GanhosBO;
import br.edu.qi.bo.UsuarioBO;
import br.edu.qi.model.Ganhos;
import br.edu.qi.model.Usuario;
import br.edu.qi.util.Sessao;
import br.edu.qi.util.Util;
import br.edu.qi.view.ReceitaModel;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.internal.SessionFactoryImpl;

/**
 * FXML Controller class
 *
 * @author Daniel de Abreu Maciel
 * @version 1.0
 */
public class TelaReceitaController implements Initializable {
   @FXML
    private ComboBox cbCategoria;
   @FXML
   private ComboBox cbFormaPagamento;
   @FXML
    private TextField txValor;
   @FXML
    private DatePicker dpData;
   @FXML
    private TextArea txDescricao;
   @FXML
    private Button btSalvar;
   @FXML
    private Button btAlterar;
   @FXML
    private Button btRemover;
   @FXML
    private Button btLogout;
   @FXML
    private Button btConfirmar;
   @FXML
   private TableView<ReceitaModel> tableReceita;
   @FXML
   private TableColumn<ReceitaModel,Double> tcValor; 
   @FXML
   private TableColumn<ReceitaModel,String> tcCategoriaGastos;
      
   @FXML
   private TableColumn<ReceitaModel,String> tcData;
   @FXML
   private TableColumn<ReceitaModel,Boolean> tcSelecao;
   
   @FXML
   private TableColumn<ReceitaModel,String> tcFormaPagamento;
   @FXML
   private TableColumn<ReceitaModel,Integer> tcIdReceita;
   private ObservableList<ReceitaModel> dadosReceita;
   private Stage dialogStage;
   private GanhosBO bo;
   private Ganhos ganho;
   private Ganhos g;
   private Usuario logado = Sessao.getInstance().getUsuario();
   private ReceitaModel recModel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ganho = new Ganhos();
        bo= new GanhosBO();
        recModel = new ReceitaModel();
        
        cbCategoria.getItems().addAll("[Selecione]","Salário","Aposentadoria",
                "Pensão","Seguro Desemprego","Aluguel","Outras Receitas");
        cbCategoria.getSelectionModel().select(0);
        cbFormaPagamento.getItems().addAll("[Selecione]","Dinheiro","Cartão");
        cbFormaPagamento.getSelectionModel().select(0);
        tcIdReceita.setCellValueFactory(new PropertyValueFactory<>("idReceita"));
        tcSelecao.setCellValueFactory(new PropertyValueFactory<>("selecao"));
        tcCategoriaGastos.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tcFormaPagamento.setCellValueFactory(new PropertyValueFactory<>("formaPagamento"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        dadosReceita = FXCollections.observableArrayList();
        dadosReceita.clear();
        dadosReceita.addAll(this.preencherTabela());
        tableReceita.setItems(dadosReceita); 
        }
      
                 
    

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }    
    
    private List<ReceitaModel> preencherTabela(){
     tableReceita.getItems().clear();
     
     List<ReceitaModel> list = new ArrayList<>();
     List<Ganhos> listaGanhos=bo.listarGanhos();
        for (Ganhos gn : listaGanhos) {
            ReceitaModel model = new ReceitaModel();
            model.setCategoria(gn.getCategoria());
            model.setData(Util.converteData(gn.getDataGanhos()));
            model.setFormaPagamento(gn.getFormaPagamento());
            model.setIdReceita(gn.getIdGanhos());
            model.setValor(gn.getValor());
            list.add(model);
        }
     return list;
    }
    
    @FXML
    private void handBtSalvar(ActionEvent event){
       try {
           validacao();
           ganho.setCategoria(cbCategoria.getSelectionModel().getSelectedItem().toString());
           LocalDate localDate = dpData.getValue();
           Date date = Util.converteLocalDate(localDate);
           if(date==null){
               Util.msgDialog("Preencha o campo de data", Alert.AlertType.ERROR);
           }else{
           ganho.setDataGanhos(date);
           ganho.setDescricao(txDescricao.getText());
           ganho.setFormaPagamento(cbFormaPagamento.getSelectionModel().getSelectedItem().toString());
           ganho.setIdUsuario(logado.getIdUsuario());
           ganho.setValor(Double.parseDouble(txValor.getText()));
           int idReceita=bo.cadastrarGanhos(ganho);
           ganho.setIdGanhos(idReceita);
           this.addTabela(ganho);
           Util.msgDialog("Ganho gravado com sucesso!", Alert.AlertType.INFORMATION);
           this.limparCampos();
           }
       } catch (Exception ex) {
           Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
       }
    }
    @FXML
    private void handBtAlterar(ActionEvent event){
        recModel = (ReceitaModel)tableReceita.getSelectionModel().getSelectedItem();
        if(recModel==null){
         Util.msgDialog("Selecione uma linha da tabela", Alert.AlertType.INFORMATION);
        }else{
        g = bo.buscaId(recModel.getIdReceita());
        txDescricao.setText(g.getDescricao());
        txValor.setText(String.valueOf(g.getValor()));
        cbCategoria.getSelectionModel().select(g.getCategoria());
        cbFormaPagamento.getSelectionModel().select(g.getFormaPagamento());
        Date date = g.getDataGanhos();
        LocalDate localDate = Util.converteDate(date);
        dpData.setValue(localDate);
        }
    }
    
    @FXML
    private void handBtRemover(ActionEvent event) throws Exception{
         ReceitaModel model = tableReceita.getSelectionModel().getSelectedItem();
         if(model==null){
           Util.msgDialog("Selecione uma linha", Alert.AlertType.ERROR);
         }else{
         dadosReceita.remove(model);
         bo.removerGanho(ganho);
         }
         }
    @FXML
    private void handBtLogout(ActionEvent event){
        Sessao.getInstance().setUsuario(null);
        
    }
    @FXML
    private void handBtConfirmar(ActionEvent event) throws Exception{
        this.validacao();
        Ganhos ganhoAnterior = g;
        g.setCategoria(cbCategoria.getSelectionModel().getSelectedItem().toString());
        g.setDescricao(txDescricao.getText());
        g.setFormaPagamento(cbFormaPagamento.getSelectionModel().getSelectedItem().toString());
        g.setValor(Double.parseDouble(txValor.getText()));
        LocalDate localDate = dpData.getValue();
        Date date = Util.converteLocalDate(localDate);
        g.setDataGanhos(date);
       try {
           bo.alterarGanhos(g, ganhoAnterior);
           Util.msgDialog("Alteração concluida com sucesso", Alert.AlertType.INFORMATION);
       } catch (Exception ex) {
           Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
       }
    }
    private void addTabela(Ganhos ganho){
        //tableReceita.getItems().clear();
        ReceitaModel dados = new ReceitaModel();
        dados.setIdReceita(ganho.getIdGanhos());
        dados.setCategoria(ganho.getCategoria());
        dados.setData(Util.converteData(ganho.getDataGanhos()));
        dados.setFormaPagamento(ganho.getFormaPagamento());
        dados.setValor(ganho.getValor());
        this.dadosReceita.add(dados);
        tableReceita.setItems(dadosReceita);
    }
    
    private void validacao() throws Exception{
        if(cbCategoria.getSelectionModel().isSelected(0)){
            throw new Exception("Escolha uma Categoria");
        }
        if(!Util.testarValor(txValor.getText())){
            throw new Exception("Informe o valor ganho");
        }
        if(dpData.getValue()==null){
            throw new Exception("Informe a Data");
        }
        if(cbFormaPagamento.getSelectionModel().isSelected(0)){
            throw new Exception("Informe a forma do pagamento");
        }
        if(txDescricao.getText().trim().length()==0){
            throw new Exception("Informe uma descrição para o ganho");
        }
        
    }
    private boolean validarSelecao(){
        int linha = tableReceita.getSelectionModel().getSelectedIndex();
        if(linha<0){
            return false;
        }
        return true;
    }
    private void limparCampos(){
      txDescricao.setText("");
      txValor.setText("");
      cbCategoria.getSelectionModel().select(0);
      cbFormaPagamento.getSelectionModel().select(0);
      dpData.setValue(null);
    }
}
