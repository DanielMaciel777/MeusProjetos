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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class HomeEditController implements Initializable {

    @FXML
    private Button btHome;
    @FXML
    private Button btDespesa;
    @FXML
    private Button btReceita;
    @FXML
    private Button btCategoria;
    @FXML
    private Button btUsuario;
    @FXML
    private Button btSobre;
    @FXML
    private Button btAjuda;
    @FXML
    private Button btSair;
    @FXML
    private AnchorPane anchorHome;
    @FXML
    private TableView tableMovimentacao;
    @FXML
    private TableColumn tcIdMovimentacao;
    @FXML
    private TableColumn tcTipo;
    @FXML
    private TableColumn tcDespesa;
    @FXML
    private TableColumn tcReceita;
    @FXML
    private TableColumn tcValorAnterior;
    @FXML
    private TableColumn tcValorNovo;
    @FXML
    private TableColumn tcData;
    @FXML
    private TextField txValorEmCaixa;
    @FXML
    private TextField txValorInicial;
    @FXML
    private TextField txTotalDespesas;
    @FXML
    private TextField txTotalReceitas;

    private Stage dialogStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handBtHome(ActionEvent event) {

    }

    @FXML
    private void handBtDespesa(ActionEvent event) {

    }

    @FXML
    private void handBtReceita(ActionEvent event) {

    }

    @FXML
    private void handBtCategoria(ActionEvent event) {

    }

    @FXML
    private void handBtUsuario(ActionEvent event) {

    }

    @FXML
    private void handBtSobre(ActionEvent event) {

    }

    @FXML
    private void handBtAjuda(ActionEvent event) {

    }

    @FXML
    private void handBtSair(ActionEvent event) {

    }
}
