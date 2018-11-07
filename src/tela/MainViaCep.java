/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class MainViaCep {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o cep, apenas os números:");
        String cep = scan.next();
        
        String request = "http://viacep.com.br/ws/"+cep+"/json/"; 
        String jSonResposta = "";
        InputStream inputStream = null;
        
        try {
            URL url = new URL(request);
            
                  HttpURLConnection con = (HttpURLConnection) url.openConnection();
             con.setRequestMethod("GET");
             con.setReadTimeout(10000);
             con.setConnectTimeout(15000);
             con.connect();
             inputStream = con.getInputStream();
             jSonResposta = new Scanner(inputStream, "UTF-8").useDelimiter("\\ A").next();
             System.out.println(jSonResposta);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainViaCep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(MainViaCep.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
