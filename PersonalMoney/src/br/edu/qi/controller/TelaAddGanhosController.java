/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.view.ReceitaModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel de Abreu Maciel
 * @version 1.0
 */
public class TelaAddGanhosController implements Initializable {
   @FXML
    private ComboBox cbCategoria;
   @FXML
   private ComboBox cbForma;
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
   private TableView tableReceita;
   @FXML
   private TableColumn tcValor, tcCategoria, tcForma, tcData, tcUsuario;
   
   private ObservableList<ReceitaModel> dadosReceita;
   private Stage dialogStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbCategoria.getItems().addAll("[Selecione]","Salário","Aposentadoria",
                "Pensão","Seguro Desemprego","Aluguel","Outras Receitas");
        cbCategoria.getSelectionModel().select(0);
        cbForma.getItems().addAll("[Selecione]","Dinheiro","Cartão");
        cbForma.getSelectionModel().select(0);
        tcUsuario.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("usuario"));
        tcCategoria.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("categoria"));
        tcForma.setCellValueFactory(new PropertyValueFactory<ReceitaModel,String>("formaPagamento"));
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
        
    }
    @FXML
    private void handBtAlterar(ActionEvent event){
        
    }
    @FXML
    private void handBtRemover(ActionEvent event){
        
    }
    @FXML
    private void handBtLogout(ActionEvent event){
        
    }
}
