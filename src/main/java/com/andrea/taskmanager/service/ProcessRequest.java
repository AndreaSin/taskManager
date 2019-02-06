package com.andrea.taskmanager.service;

import com.andrea.taskmanager.model.ProcessObj;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProcessRequest implements ProcessRequestInterface {
    @Value("${tasklistCmd}") 
    private String tasklistCmd;
   
    @Override
    public List getProcessList() {
        try {
            List<ProcessObj> procList;
            Process netStatProcess = Runtime.getRuntime().exec(tasklistCmd);
            procList = Parser.tasklistParsing(netStatProcess);
            return procList;
        } catch (IOException ex) {
            Logger.getLogger(ProcessRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}