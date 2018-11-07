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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class TelaPrincipalEditController implements Initializable {
    @FXML
    private Button btAddGanhos;
    @FXML
    private Button btAddGastos;
    @FXML
    private Button btListarMovimentacao;
    
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
    private void handBtAddGanhos(ActionEvent event){
        
    }
    
    @FXML    
    private void handBtAddGastos(ActionEvent event){
        
    }
    
    @FXML    
    private void handBtListarMovimentacao(ActionEvent event){
        
    }
}
