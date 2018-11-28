/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.scene.control.Alert;

/**
 *
 * @author danie
 */
public class Util {
    
    public static void msgDialog(String msg,Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("Personal Money");
        alert.setContentText(msg);
        alert.show();
    }
    public static Date validaData(String valor){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date data = formato.parse(valor);
            return data;
        }catch(Exception e){
            return null;
        }
    }
    
    public static String converteData(Date valor){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String texto = formato.format(valor);
        return texto;
    }
    
    public static Date converteLocalDate(LocalDate local){
        try{
        Date date = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
        }catch(Exception e){
            return null;
    }
    }
    public static LocalDate converteDate(Date date){
     
        try {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return localDate;
        } catch (Exception e) {
            return null;
        }
    }
    public static boolean testarValor(String texto){
        try {
            double valor = Double.parseDouble(texto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
