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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class TelaCadastroUsuarioController implements Initializable {
    @FXML
    private TextField txUsuario;
    @FXML
    private TextField txSenha;
    @FXML
    private TextField txRepetirSenha;
    @FXML
    private TextField txRespostaSenha;
    @FXML
    private ComboBox cbPerguntaSenha;
    @FXML
    private Button btSalvar;
    @FXML
    private Button btLimpar;
    @FXML
    private Button btSair;
             
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handBtSalvar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtLimpar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtSair(ActionEvent event){
        
    }
}
