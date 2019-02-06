package com.andrea.taskmanager.service;

import com.andrea.taskmanager.model.PortObj;
import com.andrea.taskmanager.model.ProcessObj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;

public class Parser {
    
    @Value("${jsoupFirstP}")
    private static String jsoupFirstP;
    
    /*
    Parserizza la risposta del comando netstat -n in una lista di oggetti
    PortObj   
    */
    public static List<PortObj> netstatParsing(Process netStatProcess) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(netStatProcess.getInputStream()));
            String netStatResult = new String();
            for (String line; (line = input.readLine()) != null; netStatResult += line);
            netStatResult = netStatResult.trim().replaceAll(" +", " ");
            String[] arrayString = netStatResult.split(" ");
            List<PortObj> connectionList = new ArrayList();
            for (int position=8; position+3 <= (arrayString.length); position++) {
                PortObj connectionObj = new PortObj();
                connectionObj.setProt(arrayString[position]); 
                connectionObj.setLocalAddress(arrayString[++position]); 
                connectionObj.setExtAddress(arrayString[++position]); 
                connectionObj.setStatus(arrayString[++position]); 
                connectionList.add(connectionObj);                      
            }
            return connectionList;
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    Attraverso le librerie Jsoup parserizza dal codice HTML di www.file.net
    la definizione del processo ricercato, scegliendo il paragrafo da
    visualizzare in base al contenuto.
    Chiaramente se il sito dovesse cambiare struttura la funzione smetterebbe
    di funzionare
    */
    
    public static String jsoupParsing(String processName) {
        Document doc = null;
        String firstPString;
        String processNameLow = processName.toLowerCase();
        String link = "https://www.file.net/process/" + processNameLow + ".html";
        try {
            doc = Jsoup.connect(link).get();
            Element pFirstElement = doc.select("p").first();
            firstPString = pFirstElement.text();
        }
        catch (IOException ex) {
            firstPString = "Can't find process";
            return firstPString;
        }
        if (firstPString.equals(jsoupFirstP)) {
            Element pSecElement = doc.select("div#GreyBox > p").first();
            String secondPString = pSecElement.text();
            return secondPString;
        }
        else {
            return firstPString;
        }
    }
    
    /*
    Parserizza la risposta del comando tasklist in una lista di oggetti
    ProcessObj   
    */
    
    public static List tasklistParsing(Process netStatProcess) {
        try {
            String response;
            BufferedReader input = new BufferedReader(new InputStreamReader(netStatProcess.getInputStream()));
            List<ProcessObj> procList = new ArrayList(); 
            while ((response = input.readLine()) != null) {
                ProcessObj processObj = new ProcessObj();
                String[] processArray = response.split(",");
                processObj.setNomeImmagine(processArray[0].replaceAll("\"", ""));
                processObj.setPid(processArray[1].replaceAll("\"", ""));
                processObj.setNomeSessione(processArray[2].replaceAll("\"", ""));
                processObj.setNumSessione(processArray[3].replaceAll("\"", ""));
                processObj.setMemUse(processArray[4].replaceAll("\"", ""));
                if (processObj.getNomeImmagine().endsWith("exe"))
                procList.add(processObj);
            }
            return procList;
        }
        catch (Exception err) {
            err.printStackTrace();
        }
        return null;
    }     
}
