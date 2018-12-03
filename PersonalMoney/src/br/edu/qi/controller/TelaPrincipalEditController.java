/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

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
 * @author danie
 */
public class TelaPrincipalEditController implements Initializable {
    @FXML
    private Button btReceita, btDespesa, btUsuario, btLogout;
    @FXML
    private TextField txBemVindo;
    
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
    private void handBtReceita(ActionEvent event){
     try {
            
            openWindow("/br/edu/qi/view/TelaReceitas.fxml", "Tela Receita");
        } catch (Exception e) {
            e.printStackTrace();
            Util.msgDialog(e.getMessage(),Alert.AlertType.ERROR);
        }   
    }
    
    @FXML    
    private void handBtDespesa(ActionEvent event){
        try {
            openWindow("/br/edu/qi/view/TelaAddGastos.fxml", "Tela Despesas");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(),Alert.AlertType.ERROR);
        }
    }
    
    @FXML    
    private void handBtUsuario(ActionEvent event){
        try {
            openWindow("/br/edu/qi/view/TelaCadastroUsuari.fxml", "Tela Usuário");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(),Alert.AlertType.ERROR);
        }
    }
    @FXML
    private void handBtLogout(ActionEvent event){
     Util.msgDialog("Sair do Sistema", Alert.AlertType.INFORMATION);
    }
    private void openWindow(String path, String title) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.show();
    }
}
