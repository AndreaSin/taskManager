package com.andrea.taskmanager.controller;

import com.andrea.taskmanager.model.PortObj;
import com.andrea.taskmanager.service.DescriptionProcessInterface;
import com.andrea.taskmanager.model.ProcessObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import com.andrea.taskmanager.service.ProcessRequestInterface;
import com.andrea.taskmanager.service.PortsStatusInterface;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessRequestInterface requestProcess;

    @Autowired
    DescriptionProcessInterface descriptionProcess;  
        
    @Autowired
    PortsStatusInterface connection;
       
    @GetMapping("/listProcRest")
    public List listProcRest() {
        List<ProcessObj> procList = requestProcess.getProcessList();
        return procList;
    }

    @GetMapping("/name")
    public String name(@RequestParam("id") String name) { 
        return descriptionProcess.descrProcessRecover(name);
    }
    
    @GetMapping("/ports")
    public List showPortView() {
        List<PortObj> connList = connection.getConnectionList();  
        return connList;
    }
}