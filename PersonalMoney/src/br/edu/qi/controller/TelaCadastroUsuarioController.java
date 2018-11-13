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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    private TextField txRespostaSenha;
    @FXML
    private ComboBox cbPerguntaSenha;
    @FXML
    private Button btSalvar;
    @FXML
    private Button btLimpar;
    @FXML
    private Button btSair;
    
    private Stage dialogStage;
    private UsuarioBO bo = new UsuarioBO();
    private Usuario usuario = new Usuario();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        cbPerguntaSenha.getItems().addAll("[Selecione...]","Nome da Mãe?","Nome do Pai?","Nome Animal de Estimação",
                "Filme Favorito");
        cbPerguntaSenha.getSelectionModel().select(0);
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
        if(txRespostaSenha.getText().trim().length()==0){
            throw new Exception("Informe a resposta da pergunta de recuperação "
                    + "de senha");
        }
        if(cbPerguntaSenha.getSelectionModel().isSelected(0)){
            throw new Exception("Selecione uma pergunta de recuperação");
        }
        if(!txSenha.getText().equals(txRepetirSenha.getText())){
            throw new Exception("Campo repetir senha deve ser igual ao campo senha");
        }
        
    }
    
    
    @FXML
    private void handBtSalvar(ActionEvent event){
        
        try {
            validacao();
            
            usuario.setNome(txUsuario.getText());
            usuario.setSenha(txSenha.getText());
            usuario.setPergunta(cbPerguntaSenha.getSelectionModel().getSelectedItem().toString());
            usuario.setResposta(txRespostaSenha.getText());
            bo.cadastrarUsuario(usuario);
            Util.msgDialog("Usuário gravado com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            Util.msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handBtLimpar(ActionEvent event){
        
    }
    
    @FXML
    private void handBtSair(ActionEvent event){
        
    }
}
