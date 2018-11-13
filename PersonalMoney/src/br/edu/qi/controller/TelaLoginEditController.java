/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.UsuarioBO;
import br.edu.qi.model.Usuario;
import br.edu.qi.util.Util;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel de Abreu Maciel
 * @version 1.0
 */
public class TelaLoginEditController implements Initializable {
    @FXML
    private TextField txUsuario;
    @FXML
    private TextField txSenha;
    @FXML
    private Button btEntrar;
    @FXML
    private Button btLimpar;
    @FXML
    private Button btSenha;
    @FXML
    private Button btCadastrar;
    
    private Stage dialogStage;
    private UsuarioBO bo;
    
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
    
    private void validacao() throws Exception{
        if(txUsuario.getText().trim().length()==0){
            throw new Exception("Informe o nome de usuário");
        }
        if(txSenha.getText().trim().length()==0){
            throw new Exception("Informe a senha");
        }
    }
    @FXML
    private void handBtEntrar(ActionEvent event){
        try {
            validacao();
            Usuario usu = bo.realizarLogin(txUsuario.getText(), txSenha.getText());
            if(usu!=null){
            openWindow("/br/edu/qi/view/TelaPrincipalEdit.fxml", "Tela Principal");
            }else{
                Util.msgDialog("Usuário ou senha estão incorretos", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handBtLimpar(ActionEvent event) {
        
    }
    
    @FXML
    private void handBtSenha(ActionEvent event){
        
        try {
            openWindow("/br/edu/qi/view/TelaRecuperacaoSenha.fxml", "Tela de "
                    + "Recuperação de Senha");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handBtCadastrar(ActionEvent event){
        try {
            openWindow("/br/edu/qi/view/TelaCadastroUsuario.fxml", "Cadastro de Usuário");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    private void openWindow(String path, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.show();
    }
}
