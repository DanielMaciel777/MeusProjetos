/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.GastosBO;
import br.edu.qi.model.Usuario;
import br.edu.qi.util.Sessao;
import br.edu.qi.view.DespesaModel;
import br.edu.qi.view.ReceitaModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class TelaAddGastosController implements Initializable {
   @FXML
    private ComboBox cbCategoriaGastos;
   @FXML
    private TextField txValor;
   @FXML
    private DatePicker dpData;
   @FXML
    private TextArea txDescricao;
   @FXML
    private ComboBox tcFormaPagamento;
   @FXML
    private ComboBox cbFormaPagamento;
   @FXML
    private Button btSalvar;
   @FXML
    private Button btLimpar;
   @FXML
    private Button btAlterar;
   @FXML
    private Button btConfirmar;
   @FXML
    private Button btLogout;
   @FXML
    private TableView<DespesaModel> tbGastos;
   @FXML
    private TableColumn<DespesaModel, String> tcUsuario;
   @FXML
    private TableColumn<DespesaModel, String> tcCategoria;
   @FXML
    private TableColumn<DespesaModel, String> tcForma;
   @FXML
    private TableColumn<DespesaModel, String> tcData;
   @FXML
    private TableColumn<DespesaModel, Double> tcValor;
   
   private ObservableList<DespesaModel> dadosDespesa;
   private Stage dialogStage;
   private Usuario logado = Sessao.getInstance().getUsuario();
   private DespesaModel despesaModel;
   private GastosBO bo;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bo = new GastosBO();
        despesaModel = new DespesaModel();
        //tcIdGanho.setCellValueFactory(new PropertyValueFactory<>("idGanho"));
        cbCategoriaGastos.getItems().addAll("[Selecione...]","Alimentação","Saúde","Lazer",
                "Transporte","Internet","Despesa Domestica");
        cbFormaPagamento.getItems().addAll("[Selecione...]","Dinheiro","Cartão");
        //tcCategoria
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }    
   @FXML
    private void handBtSalvar(ActionEvent event){
        
    }
    @FXML
    private void handBtLimpar(ActionEvent event){
        
    }
    @FXML
    private void handBtListarGastos(ActionEvent event){
        
    }
    @FXML
    private void handBtSair(ActionEvent event){
        
    }    
}
