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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class LoginEditController implements Initializable {
    
    @FXML
    private TextField txUsuario;
    @FXML
    private TextField txSenha;
    @FXML
    private Button btEntrar;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btMudarSenha;
    
    private Stage dialogStage;
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void handBtEntrar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtCancelar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtMudarSenha(ActionEvent event){
        
    }
}
