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
import java.util.Date;
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
   private TableView tableReceita;
   @FXML
   private TableColumn tcValor, tcCategoriaGastos, tcFormaPagamento, tcData, tcUsuario, tcIdGanho;
   
   private ObservableList<ReceitaModel> dadosReceita;
   private Stage dialogStage;
   private GanhosBO bo;
   private Ganhos ganho;
   private Usuario usuario = Sessao.getInstance().getUsuario();
   private ReceitaModel recModel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bo= new GanhosBO();
        recModel = new ReceitaModel();
        cbCategoria.getItems().addAll("[Selecione]","Salário","Aposentadoria",
                "Pensão","Seguro Desemprego","Aluguel","Outras Receitas");
        cbCategoria.getSelectionModel().select(0);
        cbFormaPagamento.getItems().addAll("[Selecione]","Dinheiro","Cartão");
        cbFormaPagamento.getSelectionModel().select(0);
        tcIdGanho.setCellValueFactory(new PropertyValueFactory<ReceitaModel,Integer>("idGanho"));
        tcUsuario.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("usuario"));
        tcCategoriaGastos.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("categoria"));
        tcFormaPagamento.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("formaPagamento"));
        tcData.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("data"));
        tcValor.setCellValueFactory(new PropertyValueFactory<ReceitaModel,Double>("valor"));
        dadosReceita = FXCollections.observableArrayList();
        tableReceita.setItems(dadosReceita);
                 
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
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
           ganho.setIdUsuario(usuario.getIdUsuario());
           ganho.setValor(Double.parseDouble(txValor.getText()));
           bo.cadastrarGanhos(ganho);
           Util.msgDialog("Ganho gravado com sucesso!", Alert.AlertType.INFORMATION);
           }
       } catch (Exception ex) {
           Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
       }
    }
    @FXML
    private void handBtAlterar(ActionEvent event){
        if(!validarSelecao()){
            Util.msgDialog("Selecione uma linha!", Alert.AlertType.INFORMATION);
        }else{
        recModel = (ReceitaModel)tableReceita.getSelectionModel().getSelectedItem();
        ganho = bo.buscaId(recModel.getIdGanho());
        txDescricao.setText(ganho.getDescricao());
        txValor.setText(String.valueOf(ganho.getValor()));
        cbCategoria.getSelectionModel().select(ganho.getCategoria());
        cbFormaPagamento.getSelectionModel().select(ganho.getFormaPagamento());
        Date date = ganho.getDataGanhos();
        LocalDate localDate = Util.converteDate(date);
        dpData.setValue(localDate);
    }
    }
    @FXML
    private void handBtRemover(ActionEvent event){
         if(!validarSelecao()){
             Util.msgDialog("Selecione uma Linha!", Alert.AlertType.INFORMATION);
         }else{
             recModel = (ReceitaModel)tableReceita.getSelectionModel().getSelectedItem();
             ganho = bo.buscaId(recModel.getIdGanho());
             try {
                 bo.removerGanho(ganho);
                 Util.msgDialog("Ganho removido com sucesso!", Alert.AlertType.INFORMATION);
             } catch (Exception ex) {
                 Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
             }
         }
    }
    @FXML
    private void handBtLogout(ActionEvent event){
        Sessao.getInstance().setUsuario(null);
        
    }
    @FXML
    private void handBtConfirmar(ActionEvent event){
        Ganhos novoGanho = new Ganhos();
        novoGanho.setCategoria(cbCategoria.getSelectionModel().getSelectedItem().toString());
        novoGanho.setDescricao(txDescricao.getText());
        novoGanho.setFormaPagamento(cbFormaPagamento.getSelectionModel().getSelectedItem().toString());
        novoGanho.setIdGanhos(ganho.getIdGanhos());
        novoGanho.setIdUsuario(usuario.getIdUsuario());
        novoGanho.setValor(Double.parseDouble(txValor.getText()));
        LocalDate localDate = dpData.getValue();
        Date date = Util.converteLocalDate(localDate);
        novoGanho.setDataGanhos(date);
       try {
           bo.alterarGanhos(novoGanho, ganho);
           Util.msgDialog("Alteração concluida com sucesso", Alert.AlertType.INFORMATION);
       } catch (Exception ex) {
           Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
       }
    }
    private void addTabela(Ganhos ganho){
        ReceitaModel dados = new ReceitaModel();
        dados.setIdGanho(ganho.getIdGanhos());
        dados.setCategoria(ganho.getCategoria());
        dados.setData(Util.converteData(ganho.getDataGanhos()));
        dados.setFormaPagamento(ganho.getFormaPagamento());
        dados.setUsuario(usuario.getNome());
        dados.setValor(ganho.getValor());
        this.dadosReceita.add(dados);
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
