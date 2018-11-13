/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class TelaListarMovimentacaoController implements Initializable {
   @FXML
   private TableView tableGanhos;
   @FXML
   private TableColumn tcIdGanhos;
   @FXML
   private TableColumn tcDescricaoGanhos;
   @FXML
   private TableColumn tcCategoriaGanhos;
   @FXML
   private TableColumn tcValorGanhos;
   @FXML
   private TableColumn tcDataGanhos;
   @FXML
   private TableView tableGastos;
   @FXML
   private TableColumn tcIdGastos;
   @FXML
   private TableColumn tcCategoriaGastos;
   @FXML
   private TableColumn tcDescricaoGastos;
   @FXML
   private TableColumn tcValorGastos;
   @FXML
   private TableColumn tcDataGastos;
   @FXML
   private Button btAlterarGanhos;
   @FXML
   private Button btRemoverGanhos;
   @FXML
   private Button btAddGanhos;
   @FXML
   private Button btAlterarGastos;
   @FXML
   private Button btRemoverGastos;
   @FXML
   private Button btAddGastos;
   @FXML
   private Button btSair;
   
   private Stage dialogStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    @FXML
    private void handBtAlterarGanhos(ActionEvent event){
        
    }
    
    @FXML
    private void handBtRemoverGanhos(ActionEvent event){
        
    }
    
    @FXML
    private void handBtAddGanhos(ActionEvent event){
        
    }
    
    @FXML
    private void handBtAlterarGastos(ActionEvent event){
        
    }
    
    @FXML
    private void handBtRemoverGastos(ActionEvent event){
        
    }
    
    @FXML
    private void handBtAddGastos(ActionEvent event){
        
    }
    
    @FXML
    private void handBtSair(ActionEvent event){
        
    }
}
