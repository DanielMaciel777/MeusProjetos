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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private TextField txValorCasa;
    @FXML
    private TextField txValorBanco;
    @FXML
    private Button btSalvar;
    @FXML
    private Button btRetornarLogin;
    @FXML
    private Button btLogout;
    
    private Stage dialogStage;
    private UsuarioBO bo = new UsuarioBO();
    private Usuario usuario = new Usuario();
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
            throw new Exception("Informe o nome do usuário!");
        }
        if(txSenha.getText().trim().length()==0){
            throw new Exception("Informe a senha!");
        }
        if(txSenha.getText().trim().length()<6){
            throw new Exception("Senha deve ter pelo menos 6 digitos");
        }
        if(txRepetirSenha.getText().trim().length()==0){
            throw new Exception("Informe a senha novamente!");
        }
        if(txRepetirSenha.getText().trim().length()<6){
            throw new Exception("Senha deve ter pelo menos 6 digitos");
        }
        if(!txSenha.getText().equals(txRepetirSenha.getText())){
            throw new Exception("Campo repetir senha deve ser igual ao campo senha");
        }
        if(!Util.testarValor(txValorBanco.getText())){
            throw new Exception("Campo valor banco deve ser um numero!");
        }
        if(!Util.testarValor(txValorCasa.getText())){
             throw new Exception("Campo valor casa deve ser um numero!");
        }
        
    }
    
    
    @FXML
    private void handBtSalvar(ActionEvent event){
        
        try {
            validacao();
            usuario.setNome(txUsuario.getText());
            usuario.setSenha(txSenha.getText());
            usuario.setValorBanco(Double.parseDouble(txValorBanco.getText()));
            usuario.setValorCasa(Double.parseDouble(txValorCasa.getText()));
            bo.cadastrarUsuario(usuario);
            Util.msgDialog("Usuário gravado com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handBtRetornarLogin(ActionEvent event){
        try {
            openWindow("/br/edu/qi/view/TelaLogin.fxml", "Tela Login");
        } catch (Exception ex) {
          Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handBtLogout(ActionEvent event){
        
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
