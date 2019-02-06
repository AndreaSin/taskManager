package com.andrea.taskmanager.service;

import org.springframework.stereotype.Service;

@Service
public class DescriptionProcess implements DescriptionProcessInterface {

    @Override
    public String descrProcessRecover(String processName) {
        String descriptionProces = Parser.jsoupParsing(processName);
        return descriptionProces;
    }
}