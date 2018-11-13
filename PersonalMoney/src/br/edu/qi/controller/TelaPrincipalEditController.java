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
import javafx.stage.Modality;
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
     try {
            openWindow("/br/edu/qi/view/TelaAddGanhos.fxml", "Tela de Ganhos");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(),Alert.AlertType.ERROR);
        }   
    }
    
    @FXML    
    private void handBtAddGastos(ActionEvent event){
        try {
            openWindow("/br/edu/qi/view/TelaAddGastos.fxml", "Tela de Gastos");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(),Alert.AlertType.ERROR);
        }
    }
    
    @FXML    
    private void handBtListarMovimentacao(ActionEvent event){
        try {
            openWindow("/br/edu/qi/view/TelaListarMovimentacao.fxml", "Registro de Ganhos e Gastos");
        } catch (Exception e) {
            Util.msgDialog(e.getMessage(),Alert.AlertType.ERROR);
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
