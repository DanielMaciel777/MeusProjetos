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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class TelaRecuperacaoSenhaController implements Initializable {
    @FXML
    private TextField txUsuario;
    @FXML
    private TextField txRespostaRecuperacao;
    @FXML
    private TextField txRespostaNova;
    @FXML
    private PasswordField txNovaSenha;
    @FXML
    private PasswordField txRepetirSenha;
    @FXML
    private ComboBox cbPerguntaRecuperacao;
    @FXML
    private ComboBox cbPerguntaNova;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btLimpar;
    @FXML
    private Button btSair;
    @FXML
    private Button btSalvarSenha;
    
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
    private void handBtConfirmar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtLimpar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtSair(ActionEvent event){
        
    }
    
    @FXML
    private void handBtSalvarSenha(ActionEvent event){
        
    }
}
