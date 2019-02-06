package com.andrea.taskmanager.service;

import com.andrea.taskmanager.model.PortObj;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PortsStatus implements PortsStatusInterface {
    
    @Value("${netstatCmd}")    
    private String netstatCmd;

    @Override
    public List getConnectionList() {
        try {
            Process netStatProcess = Runtime.getRuntime().exec(netstatCmd);
            List<PortObj> connectionList = Parser.netstatParsing(netStatProcess);
            return connectionList;
        } catch (IOException ex) {
            Logger.getLogger(PortsStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}